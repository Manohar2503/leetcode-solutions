class Solution {

    int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public boolean containsCycle(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!visited[i][j]) {

                    if (dfs(i, j, -1, -1, grid, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(
            int row,
            int col,
            int parentRow,
            int parentCol,
            char[][] grid,
            boolean[][] visited) {

        visited[row][col] = true;

        for (int[] dir : directions) {

            int newRow = row + dir[0];
            int newCol = col + dir[1];

            // Out of bounds
            if (newRow < 0 || newRow >= grid.length ||
                newCol < 0 || newCol >= grid[0].length) {
                continue;
            }

            // Different character
            if (grid[newRow][newCol] != grid[row][col]) {
                continue;
            }

            // Don't go directly back to the parent
            if (newRow == parentRow && newCol == parentCol) {
                continue;
            }

            // Same character + already visited + not parent = cycle
            if (visited[newRow][newCol]) {
                return true;
            }

            if (dfs(
                    newRow,
                    newCol,
                    row,
                    col,
                    grid,
                    visited)) {
                return true;
            }
        }

        return false;
    }
}