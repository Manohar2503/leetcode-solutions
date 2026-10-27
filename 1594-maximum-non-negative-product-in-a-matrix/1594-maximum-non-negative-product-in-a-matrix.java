class Solution {
    
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        int[][][] dp = new int[m][n][2];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];

        int prev = grid[0][0];
        for(int i=1;i<n;i++){
            prev *= grid[0][i];
            dp[0][i][0] = prev;
            dp[0][i][1] = prev; 
        }

        prev = grid[0][0];
        for(int i=1;i<m;i++){
            prev *= grid[i][0];
            dp[i][0][0] = prev;
            dp[i][0][1] = prev; 
        }


        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int p1 = (grid[i][j] * dp[i-1][j][0]) % MOD;
                int p2 = (grid[i][j] * dp[i-1][j][1]) % MOD;
                int p3 = (grid[i][j] * dp[i][j-1][0]) % MOD;
                int p4 = (grid[i][j] * dp[i][j-1][1]) % MOD;
                
                dp[i][j][0] = Math.max(Math.max(p1,p2), Math.max(p3,p4));
                dp[i][j][1] = Math.min(Math.min(p1,p2), Math.min(p3,p4));
            }
        }

        return (dp[m-1][n-1][0] <0)?-1:dp[m-1][n-1][0];
    }
}