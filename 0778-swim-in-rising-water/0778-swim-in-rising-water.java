class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] adjNodes = {{0,1}, {1,0}, {-1, 0}, {0,-1}};
        int[][] dp = new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int[]{0,0,0});

        int time =0;
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int r = current[0];
            int c = current[1];
            int t = current[2];

            if(t>dp[r][c]) continue;
            int val = grid[r][c];
            if(val > time) time = val;
            if(r == n-1 && c == n-1) return time;

            for(int[] nodes: adjNodes){
                int nr = r + nodes[0];
                int nc = c + nodes[1];

                if(nr<0 || nr >=n || nc <0 || nc>=m) continue;
                int min_time = Math.max(time+1, grid[nr][nc]);
                if(min_time < dp[nr][nc]){
                    pq.offer(new int[]{nr, nc, grid[nr][nc]});
                    dp[nr][nc] = min_time;
                }

            }

        }

        return 0;
    }
}