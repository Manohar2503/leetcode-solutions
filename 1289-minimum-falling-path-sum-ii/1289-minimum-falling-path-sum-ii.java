
import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int result = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            result = Math.min(
                result,
                grid[0][col] + pathSum(1, col, grid, dp)
            );
        }

        return result;
    }

    static int pathSum(int index, int prevCol, int[][] grid, int[][] dp) {
        int n = grid.length;

        if (index == n) {
            return 0;
        }

        if (dp[index][prevCol] != Integer.MAX_VALUE) {
            return dp[index][prevCol];
        }

        int result = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            if (col == prevCol) {
                continue;
            }

            int current = grid[index][col]
                        + pathSum(index + 1, col, grid, dp);

            result = Math.min(result, current);
        }

        return dp[index][prevCol] = result;
    }
}
