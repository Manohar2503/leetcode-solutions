class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0,0});
        visited[0][0] = true;
        int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int time = 0;

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currentTime = current[0];
            int u = current[1];
            int v = current[2];
            if(time < currentTime) time = currentTime;
            if(u == n-1 && v == m-1) return time;
            
            for(int[] adj: dir){
                int nu = u + adj[0];
                int nv = v + adj[1];

                if(nu>=0 && nu<n && nv>=0 && nv<m && !visited[nu][nv]){
                    visited[nu][nv] = true;
                    pq.offer(new int[]{grid[nu][nv], nu, nv});
                }
            }
        }

        return -1;
    }
}
/**



*/