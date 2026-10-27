import java.util.Arrays;

class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        int[] adj = {-1, 0, 1};

        return paths(0, 0, m - 1, grid, dp, adj);
    }

    static int paths(int r, int c1, int c2,
                 int[][] grid, int[][][] dp, int[] adj) {

    int n = grid.length;
    int m = grid[0].length;
    // 1. Reject invalid columns first
    if (c1 < 0 || c1 >= m || c2 < 0 || c2 >= m) {
        return 0;
    }

    // 2. Base case: last row
    if (r == n - 1) {
        if (c1 == c2) {
            return grid[r][c1];
        }
        return grid[r][c1] + grid[r][c2];
    }

    // 3. Memoization lookup
    if (dp[r][c1][c2] != -1) {
        return dp[r][c1][c2];
    }

    int current = (c1 == c2)
        ? grid[r][c1]
        : grid[r][c1] + grid[r][c2];

    int best = 0;

    for (int i : adj) {
        for (int j : adj) {
            int next = paths(r + 1, c1 + i, c2 + j,
                             grid, dp, adj);

            best = Math.max(best, current + next);
        }
    }

    return dp[r][c1][c2] = best;
}
}