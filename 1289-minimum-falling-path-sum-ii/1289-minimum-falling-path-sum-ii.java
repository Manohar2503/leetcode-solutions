import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        return path(n, 0, n, grid, dp);
    }

    static int path(int previous, int index, int n,
                    int[][] grid, int[][] dp) {

        if (index == n) return 0;

        if (dp[index][previous] != Integer.MAX_VALUE) {
            return dp[index][previous];
        }

        int minVal = Integer.MAX_VALUE;

        for (int c = 0; c < n; c++) {

            if (previous != c) {

                int val = grid[index][c] +
                          path(c, index + 1, n, grid, dp);

                minVal = Math.min(minVal, val);
            }
        }

        return dp[index][previous] = minVal;
    }
}