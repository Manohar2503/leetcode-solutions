
class Solution {

    public int cutOffTree(List<List<Integer>> forest) {

        int m = forest.size();
        int n = forest.get(0).size();

        if (forest.get(0).get(0) == 0) return -1;

        // Step 1: Collect all trees
        List<int[]> trees = new ArrayList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                int height = forest.get(r).get(c);

                if (height > 1) {
                    trees.add(new int[]{height, r, c});
                }
            }
        }

        // Step 2: Sort trees by height
        trees.sort((a, b) -> Integer.compare(a[0], b[0]));

        int totalSteps = 0;

        // Starting position
        int sr = 0;
        int sc = 0;

        // Step 3: Reach each tree in sorted order
        for (int[] tree : trees) {

            int tr = tree[1];
            int tc = tree[2];

            int steps = bfs(forest, sr, sc, tr, tc);

            if (steps == -1) return -1;

            totalSteps += steps;

            // Update current position
            sr = tr;
            sc = tc;
        }

        return totalSteps;
    }

    private int bfs(List<List<Integer>> forest,
                    int sr, int sc, int tr, int tc) {

        int m = forest.size();
        int n = forest.get(0).size();

        if (sr == tr && sc == tc) return 0;

        int[][] directions = {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
        };

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{sr, sc, 0});
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int r = current[0];
            int c = current[1];
            int steps = current[2];

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nc < 0 ||
                    nr >= m || nc >= n ||
                    visited[nr][nc] ||
                    forest.get(nr).get(nc) == 0) {
                    continue;
                }

                if (nr == tr && nc == tc) {
                    return steps + 1;
                }

                visited[nr][nc] = true;

                queue.offer(new int[]{
                    nr, nc, steps + 1
                });
            }
        }

        return -1;
    }
}
