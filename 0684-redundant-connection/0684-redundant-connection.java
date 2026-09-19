class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        parent = new int[n + 1];

        // Initially every node is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            int parentU = find(u);
            int parentV = find(v);

            // Cycle found
            if (parentU == parentV) {
                return edge;
            }
       // Union
            parent[parentU] = parentV;
        }

        return new int[0];
    }

    private int find(int node) {

        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path Compression
        }

        return parent[node];
    }
}