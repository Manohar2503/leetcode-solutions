class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] f: flights){
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0}); // node, cost, stops
        dist[src] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int node = cur[0];
            int cost = cur[1];
            int stops = cur[2];

            if(stops > k) continue;

            for(int[] nei : adj.get(node)){
                int next = nei[0];
                int price = nei[1];

                if(cost + price < dist[next]){
                    dist[next] = cost + price;
                    q.offer(new int[]{next, dist[next], stops + 1});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
