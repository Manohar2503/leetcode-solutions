
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        int[] dp = grid[0].clone();

        for (int row = 1; row < n; row++) {
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            int minCol = -1;

            // Find the smallest and second-smallest values
            // in the previous row.
            for (int col = 0; col < n; col++) {
                if (dp[col] < min1) {
                    min2 = min1;
                    min1 = dp[col];
                    minCol = col;
                } else if (dp[col] < min2) {
                    min2 = dp[col];
                }
            }

            int[] curr = new int[n];

            for (int col = 0; col < n; col++) {
                int best = (col == minCol) ? min2 : min1;
                curr[col] = grid[row][col] + best;
            }

            dp = curr;
        }

        int result = Integer.MAX_VALUE;

        for (int value : dp) {
            result = Math.min(result, value);
        }

        return result;
    }
}
