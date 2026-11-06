
class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();

        char[][] matrix = new char[n][m];

        int startRow = -1;
        int startCol = -1;
        int totalKeys = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = grid[i].charAt(j);
                matrix[i][j] = ch;

                if (ch == '@') {
                    startRow = i;
                    startCol = j;
                }

                if (ch >= 'a' && ch <= 'z') {
                    totalKeys++;
                }
            }
        }

        int target = (1 << totalKeys) - 1;

        Queue<int[]> qu = new LinkedList<>();
        boolean[][][] visited =
            new boolean[n][m][1 << totalKeys];

        qu.offer(new int[]{startRow, startCol, 0});
        visited[startRow][startCol][0] = true;

        int[][] adjNodes = {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };

        int steps = 0;

        while (!qu.isEmpty()) {
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                int[] current = qu.poll();

                int r = current[0];
                int c = current[1];
                int keys = current[2];

                if (keys == target) return steps;

                for (int[] node : adjNodes) {
                    int nr = r + node[0];
                    int nc = c + node[1];

                    if (nr < 0 || nc < 0 ||
                        nr >= n || nc >= m) {
                        continue;
                    }

                    char ch = matrix[nr][nc];

                    if (ch == '#') continue;

                    // Check lock
                    if (ch >= 'A' && ch <= 'Z') {
                        int bit = 1 << (ch - 'A');

                        if ((keys & bit) == 0) continue;
                    }

                    // Collect key
                    int newKeys = keys;

                    if (ch >= 'a' && ch <= 'z') {
                        int bit = 1 << (ch - 'a');
                        newKeys |= bit;
                    }

                    if (!visited[nr][nc][newKeys]) {
                        visited[nr][nc][newKeys] = true;

                        qu.offer(new int[]{
                            nr, nc, newKeys
                        });
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
