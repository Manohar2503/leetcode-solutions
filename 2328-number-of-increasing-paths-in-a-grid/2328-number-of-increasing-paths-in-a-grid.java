class Solution {
    static int MOD = 1_000_000_007;

    public int countPaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Integer[][] dp = new Integer[n][m];
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = (result + paths(i, j, grid, dp)) % MOD;
            }
        }

        return result;
    }

    static int paths(int r, int c, int[][] grid, Integer[][] dp) {

        if (dp[r][c] != null) return dp[r][c];

        int up = 0, down = 0, left = 0, right = 0;

        if (r - 1 >= 0 && grid[r - 1][c] > grid[r][c])
            up = paths(r - 1, c, grid, dp);

        if (c - 1 >= 0 && grid[r][c - 1] > grid[r][c])
            left = paths(r, c - 1, grid, dp);

        if (r + 1 < grid.length && grid[r + 1][c] > grid[r][c])
            down = paths(r + 1, c, grid, dp);

        if (c + 1 < grid[0].length && grid[r][c + 1] > grid[r][c])
            right = paths(r, c + 1, grid, dp);

        long total = 1L + up + down + left + right;

        return dp[r][c] = (int)(total % MOD);
    }
}