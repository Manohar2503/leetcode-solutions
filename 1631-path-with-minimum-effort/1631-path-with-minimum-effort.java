class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] directions = {
            {-1, 0}, {0, -1}, {0, 1}, {1, 0}
        };

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        pq.offer(new int[]{0, 0, 0});
        dp[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int r = current[0];
            int c = current[1];
            int effort = current[2];

            // Ignore outdated states.
            if (effort > dp[r][c]) {
                continue;
            }

            // The minimum-effort destination has been reached.
            if (r == n - 1 && c == m - 1) {
                return effort;
            }

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                int edgeEffort =
                    Math.abs(heights[r][c] - heights[nr][nc]);

                int newEffort = Math.max(effort, edgeEffort);

                if (newEffort < dp[nr][nc]) {
                    dp[nr][nc] = newEffort;
                    pq.offer(new int[]{nr, nc, newEffort});
                }
            }
        }

        return 0;
    }
}