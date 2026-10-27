import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        // -1 means this cell is unreachable.
        for (int[] row : score) {
            Arrays.fill(row, -1);
        }

        // Start from E.
        score[0][0] = 0;
        ways[0][0] = 1;

        int[][] prev = {
            {-1, 0},   // Above
            {0, -1},   // Left
            {-1, -1}   // Diagonal
        };

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if ((r == 0 && c == 0)
                    || board.get(r).charAt(c) == 'X') {
                    continue;
                }

                int best = -1;
                int count = 0;

                for (int[] d : prev) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nc < 0 || score[nr][nc] == -1) {
                        continue;
                    }

                    if (score[nr][nc] > best) {
                        best = score[nr][nc];
                        count = ways[nr][nc];
                    } else if (score[nr][nc] == best) {
                        count = (int) (
                            ((long) count + ways[nr][nc]) % MOD
                        );
                    }
                }

                if (best == -1) {
                    continue;
                }

                char ch = board.get(r).charAt(c);
                int value = Character.isDigit(ch) ? ch - '0' : 0;

                score[r][c] = best + value;
                ways[r][c] = count;
            }
        }

        if (score[n - 1][n - 1] == -1) {
            return new int[]{0, 0};
        }

        return new int[]{
            score[n - 1][n - 1],
            ways[n - 1][n - 1]
        };
    }
}