class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        if (n == 1 && m == 1) return 0;

        if (k >= n + m - 2) {
            return n + m - 2;
        }

        int[][] directions = {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}
        };

        boolean[][][] visited = new boolean[n][m][k + 1];

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];
            int steps = current[2];
            int obstacles = current[3];

            if (r == n - 1 && c == m - 1) {
                return steps;
            }

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                int nextObstacles = obstacles + grid[nr][nc];

                if (nextObstacles > k) {
                    continue;
                }

                if (visited[nr][nc][nextObstacles]) {
                    continue;
                }

                visited[nr][nc][nextObstacles] = true;

                queue.offer(new int[]{
                    nr, nc, steps + 1, nextObstacles
                });
            }
        }

        return -1;
    }
}