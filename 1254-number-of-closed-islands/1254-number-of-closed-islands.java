class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Boolean[][] dp = new Boolean[n][m];
        int result =0;
        int[][] adjNodes = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1 || dp[i][j]!=null || grid[i][j]==1) continue;
                else{
                    if(dfs(i,j,grid,dp, adjNodes)) result++;
                }
            }
        }

        return result;
    }

    static boolean dfs(int r, int c, int[][] grid, Boolean[][] dp, int[][] adjNodes){
        if(r == 0 || c == 0 || r == grid.length-1 || c == grid[0].length-1) {
            if(grid[r][c] == 1) return true;
            else return false;
        }

        if(dp[r][c]!=null) return dp[r][c];
        if(grid[r][c]==1) return true;
        dp[r][c] = true;

        for(int[] nodes: adjNodes){
            int nr = r + nodes[0];
            int nc = c + nodes[1];

            if(nr >=0 && nr<grid.length && nc>=0 && nc < grid[0].length){
                dp[nr][nc] = dfs(nr,nc,grid,dp,adjNodes);
                dp[r][c] &= dp[nr][nc];
            }

        }

        return dp[r][c];
    }
}