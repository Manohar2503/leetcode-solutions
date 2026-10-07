class Solution {

    int[] parent;

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;

        // Each cell has 4 triangles
        // 0 = top
        // 1 = right
        // 2 = bottom
        // 3 = left
        parent = new int[4 * n * n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                int base = 4 * (r * n + c);

                // Split the current cell
                char ch = grid[r].charAt(c);

                if (ch == ' ') {
                    // All 4 triangles are connected
                    union(base + 0, base + 1);
                    union(base + 1, base + 2);
                    union(base + 2, base + 3);

                } else if (ch == '/') {
                    // / separates:
                    // top + left
                    // right + bottom
                    union(base + 0, base + 3);
                    union(base + 1, base + 2);

                } else { // '\'
                    // \ separates:
                    // top + right
                    // bottom + left
                    union(base + 0, base + 1);
                    union(base + 2, base + 3);
                }

                // Connect with the cell below
                if (r + 1 < n) {
                    int bottom = 4 * ((r + 1) * n + c);

                    // current bottom ↔ below top
                    union(base + 2, bottom + 0);
                }

                // Connect with the cell to the right
                if (c + 1 < n) {
                    int right = 4 * (r * n + (c + 1));

                    // current right ↔ right cell left
                    union(base + 1, right + 3);
                }
            }
        }

        // Count number of different roots
        int regions = 0;

        for (int i = 0; i < parent.length; i++) {
            if (find(i) == i) {
                regions++;
            }
        }

        return regions;
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pa] = pb;
        }
    }
}