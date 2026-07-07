class Solution {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        // parent[i] = parent of node i in the original graph
        int[] parent = new int[n + 1];

        int[] candidate1 = null;
        int[] candidate2 = null;

        // Step 1: Check if any node has two parents
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (parent[v] == 0) {
                parent[v] = u;
            } else {
                candidate1 = new int[]{parent[v], v}; // first parent
                candidate2 = new int[]{u, v};         // second parent

                // Mark candidate2 to be skipped later
                edge[1] = 0;
            }
        }

        // Step 2: Initialize Union-Find
        int[] ufParent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ufParent[i] = i;
        }

        // Step 3: Perform Union-Find
        for (int[] edge : edges) {

            if (edge[1] == 0) continue; // Skip candidate2

            int u = edge[0];
            int v = edge[1];

            int pu = find(ufParent, u);

            if (pu == v) {
                // Cycle found
                if (candidate1 == null) {
                    return edge;
                }
                System.out.print("# ");
                return candidate1;
            }

            ufParent[v] = pu;
        }

        // Step 4: No cycle after removing candidate2
        return candidate2;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}