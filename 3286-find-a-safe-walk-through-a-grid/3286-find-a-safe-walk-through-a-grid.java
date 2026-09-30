class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int n = grid.size();
        int m = grid.get(0).size();

        int[][] maxHealth = new int[n][m];

        for (int[] row : maxHealth) {
            Arrays.fill(row, -1);
        }

        int startHealth = health - grid.get(0).get(0);
        if (startHealth < 1) {
            return false;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, startHealth});
        maxHealth[0][0] = startHealth;

        int[][] directions = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];
            int currentHealth = current[2];

            if (r == n - 1 && c == m - 1) {
                return true;
            }

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m) {

                    int newHealth =
                        currentHealth - grid.get(nr).get(nc);

                    if (newHealth >= 1 &&
                        newHealth > maxHealth[nr][nc]) {
                        maxHealth[nr][nc] = newHealth;
                        queue.offer(
                            new int[]{nr, nc, newHealth}
                        );
                    }
                }
            }
        }

        return false;
    }
}