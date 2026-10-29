
import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] adjNodes = {
            {0, 1},   // Right = 1
            {0, -1},  // Left = 2
            {1, 0},   // Down = 3
            {-1, 0}   // Up = 4
        };

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a[2], b[2]));

        dp[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int r = current[0];
            int c = current[1];
            int curCost = current[2];

            if (curCost > dp[r][c]) continue;

            if (r == n - 1 && c == m - 1) {
                return curCost;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + adjNodes[d][0];
                int nc = c + adjNodes[d][1];

                if (nr < 0 || nr >= n ||
                    nc < 0 || nc >= m) {
                    continue;
                }

                int newCost =
                    curCost + (grid[r][c] == d + 1 ? 0 : 1);

                if (newCost < dp[nr][nc]) {
                    dp[nr][nc] = newCost;
                    pq.offer(new int[]{nr, nc, newCost});
                }
            }
        }

        return -1;
    }
}
