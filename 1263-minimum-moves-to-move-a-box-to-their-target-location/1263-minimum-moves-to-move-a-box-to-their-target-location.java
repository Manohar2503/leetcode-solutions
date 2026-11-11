
import java.util.*;

class Solution {
    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int br = 0, bc = 0;
        int pr = 0, pc = 0;
        int tr = 0, tc = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') {
                    br = i;
                    bc = j;
                } else if (grid[i][j] == 'S') {
                    pr = i;
                    pc = j;
                } else if (grid[i][j] == 'T') {
                    tr = i;
                    tc = j;
                }
            }
        }

        int[][] dirs = {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };

        int[][][][] dist = new int[m][n][m][n];

        for (int[][][] a : dist) {
            for (int[][] b : a) {
                for (int[] c : b) {
                    Arrays.fill(c, Integer.MAX_VALUE);
                }
            }
        }

        // State: playerR, playerC, boxR, boxC
        Deque<int[]> dq = new ArrayDeque<>();

        dist[pr][pc][br][bc] = 0;
        dq.offerFirst(new int[]{pr, pc, br, bc});

        while (!dq.isEmpty()) {

            int[] curr = dq.pollFirst();

            int r = curr[0];
            int c = curr[1];
            int boxR = curr[2];
            int boxC = curr[3];

            int pushes = dist[r][c][boxR][boxC];

            if (boxR == tr && boxC == tc) {
                return pushes;
            }

            for (int[] d : dirs) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nc < 0 ||
                    nr >= m || nc >= n ||
                    grid[nr][nc] == '#') {
                    continue;
                }

                int newBoxR = boxR;
                int newBoxC = boxC;
                int cost = 0;

                // Player encounters the box
                if (nr == boxR && nc == boxC) {

                    newBoxR = boxR + d[0];
                    newBoxC = boxC + d[1];

                    // Check whether the box can be pushed
                    if (newBoxR < 0 || newBoxC < 0 ||
                        newBoxR >= m || newBoxC >= n ||
                        grid[newBoxR][newBoxC] == '#') {
                        continue;
                    }

                    cost = 1;
                }

                int newDist = pushes + cost;

                if (newDist < dist[nr][nc][newBoxR][newBoxC]) {

                    dist[nr][nc][newBoxR][newBoxC] = newDist;

                    int[] next = {
                        nr, nc, newBoxR, newBoxC
                    };

                    if (cost == 0) {
                        dq.offerFirst(next);
                    } else {
                        dq.offerLast(next);
                    }
                }
            }
        }

        return -1;
    }
}
