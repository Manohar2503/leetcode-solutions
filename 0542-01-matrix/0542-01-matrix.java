class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dp= new int[n][m];
        Queue<int[]> qu = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    qu.offer(new int[]{i,j});
                }
                else dp[i][j] = -1;
            }
        }
        int[][] adj = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        while(!qu.isEmpty()){
            int[] current = qu.poll();
            int r = current[0];
            int c = current[1];

            for(int[] adjNode : adj){
                int nr = r + adjNode[0];
                int nc = c + adjNode[1];

                if(nr>=0 && nr <n && nc >=0 && nc < m && dp[nr][nc] == -1){
                    dp[nr][nc] = dp[r][c] +1;
                    qu.offer(new int[]{nr, nc});
                }
            }
        }

        return dp;
    }
}