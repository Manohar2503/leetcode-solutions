import java.util.Arrays;

class Solution {
    static final int NEG = -1_000_000;

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][][] dp = new int[n][n][n][n];

        for (int[][][] a : dp) {
            for (int[][] b : a) {
                for (int[] c : b) {
                    Arrays.fill(c, -1);
                }
            }
        }

        int result = path(0, 0, 0, 0, grid, dp);
        return Math.max(0, result);
    }

    static int path(int r1, int c1, int r2, int c2,
                    int[][] grid, int[][][][] dp) {

        int n = grid.length;

        if (r1 >= n || c1 >= n ||
            r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 ||
            grid[r2][c2] == -1) {
            return NEG;
        }

        if (r1 == n - 1 && c1 == n - 1 &&
            r2 == n - 1 && c2 == n - 1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2][c2] != -1) {
            return dp[r1][c1][r2][c2];
        }

        int cherries = grid[r1][c1];

        if (r1 != r2 || c1 != c2) {
            cherries += grid[r2][c2];
        }

        int f1 = path(r1, c1 + 1, r2, c2 + 1, grid, dp);
        int f2 = path(r1 + 1, c1, r2, c2 + 1, grid, dp);
        int f3 = path(r1 + 1, c1, r2 + 1, c2, grid, dp);
        int f4 = path(r1, c1 + 1, r2 + 1, c2, grid, dp);

        int best = Math.max(
            Math.max(f1, f2),
            Math.max(f3, f4)
        );

        if (best == NEG) {
            return dp[r1][c1][r2][c2] = NEG;
        }

        return dp[r1][c1][r2][c2] = cherries + best;
    }
}