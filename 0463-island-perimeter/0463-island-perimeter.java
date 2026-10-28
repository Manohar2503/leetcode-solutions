class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;

        int[][] dirs = {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];

                        if (nr < 0 || nr >= m ||
                            nc < 0 || nc >= n ||
                            grid[nr][nc] == 0) {
                            perimeter++;
                        }
                    }
                }
            }
        }

        return perimeter;
    }
}