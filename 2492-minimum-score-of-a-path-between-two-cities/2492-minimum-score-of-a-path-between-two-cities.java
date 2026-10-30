class Solution {
    public int minScore(int n, int[][] roads) {

        List<List<int[]>> adjList = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adjList.get(u).add(new int[]{v, w});
            adjList.get(v).add(new int[]{u, w});
        }

        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        int ans = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {

            int u = queue.poll();

            for(int[] node : adjList.get(u)) {

                int v = node[0];
                int w = node[1];

                ans = Math.min(ans, w);

                if(!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }

        return ans;
    }
}