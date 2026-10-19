class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adjList = new ArrayList[n+1];
        for(int i=0;i<=n;i++) adjList[i] = new ArrayList<>();

        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            adjList[u].add(new int[]{v,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> a[0] - b[0]);
        int[] shortestDis = new int[n+1];
        Arrays.fill(shortestDis, Integer.MAX_VALUE);
        shortestDis[k] =0;
        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currentNode = current[1];
            int currentWeight = current[0];

            if(currentWeight > shortestDis[currentNode]) continue;
            for(int[] adj: adjList[currentNode]){
                int v = adj[0];
                int w = adj[1];

                if(currentWeight + w < shortestDis[v]){
                    shortestDis[v] = currentWeight + w;
                    pq.offer(new int[]{shortestDis[v], v});
                }
            }
        }
        int time =0;
        for(int i=1;i<=n;i++){
            if(shortestDis[i] == Integer.MAX_VALUE) return -1;
            time = Math.max(time, shortestDis[i]);
        }

        return time;
    }
}
/**




*/