class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        int[][][] dp = new int[m][n][k];

        int div = grid[0][0] % k;
        dp[0][0][div] = 1;

        // First row
        for (int j = 1; j < n; j++) {
            div = (div + grid[0][j]) % k;
            dp[0][j][div] = 1;
        }

        // First column
        div = grid[0][0] % k;
        for (int i = 1; i < m; i++) {
            div = (div + grid[i][0]) % k;
            dp[i][0][div] = 1;
        }

        // Remaining cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int r = 0; r < k; r++) {
                    int nr = (r + grid[i][j]) % k;

                    long ways = (long) dp[i][j - 1][r]
                              + dp[i - 1][j][r];

                    dp[i][j][nr] = (int) (
                        (dp[i][j][nr] + ways) % MOD
                    );
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}