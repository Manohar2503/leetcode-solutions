import java.util.Arrays;

class Solution {

    int[][][] dp;
    int rows, cols;
    int[] dir = {-1, 0, 1};

    public int cherryPickup(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        dp = new int[rows][cols][cols];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return dfs(0, 0, cols - 1, grid);
    }

    private int dfs(int row, int col1, int col2, int[][] grid) {

        // Out of bounds
        if (col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return Integer.MIN_VALUE;
        }

        // Last row
        if (row == rows - 1) {
            if (col1 == col2)
                return grid[row][col1];
            return grid[row][col1] + grid[row][col2];
        }

        if (dp[row][col1][col2] != -1)
            return dp[row][col1][col2];

        int max = 0;

        // Try all 9 combinations
        for (int d1 : dir) {
            for (int d2 : dir) {
                max = Math.max(max,
                        dfs(row + 1, col1 + d1, col2 + d2, grid));
            }
        }

        int cherries;
        if (col1 == col2)
            cherries = grid[row][col1];
        else
            cherries = grid[row][col1] + grid[row][col2];

        dp[row][col1][col2] = cherries + max;
        return dp[row][col1][col2];
    }
}