import java.util.Arrays;

class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int steps = 2 * n - 2;

        // dp[k][r1][r2]:
        // Maximum cherries collected after k moves,
        // with person 1 at (r1, k-r1)
        // and person 2 at (r2, k-r2).

        int[][][] dp = new int[steps + 1][n][n];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        dp[0][0][0] = grid[0][0];

        for (int k = 1; k <= steps; k++) {
            int minRow = Math.max(0, k - (n - 1));
            int maxRow = Math.min(n - 1, k);

            for (int r1 = minRow; r1 <= maxRow; r1++) {
                for (int r2 = minRow; r2 <= maxRow; r2++) {

                    int c1 = k - r1;
                    int c2 = k - r2;

                    if (grid[r1][c1] == -1 ||
                        grid[r2][c2] == -1) {
                        continue;
                    }

                    int best = -1;

                    // Both came from above.
                    best = Math.max(best,
                        dp[k - 1][r1][r2]);

                    // Person 1 came from the left.
                    if (r1 > 0) {
                        best = Math.max(best,
                            dp[k - 1][r1 - 1][r2]);
                    }

                    // Person 2 came from the left.
                    if (r2 > 0) {
                        best = Math.max(best,
                            dp[k - 1][r1][r2 - 1]);
                    }

                    // Both came from the left.
                    if (r1 > 0 && r2 > 0) {
                        best = Math.max(best,
                            dp[k - 1][r1 - 1][r2 - 1]);
                    }

                    if (best == -1) {
                        continue;
                    }

                    int cherries = grid[r1][c1];

                    // Avoid counting a shared cell twice.
                    if (r1 != r2) {
                        cherries += grid[r2][c2];
                    }

                    dp[k][r1][r2] = best + cherries;
                }
            }
        }

        return Math.max(0, dp[steps][n - 1][n - 1]);
    }
}