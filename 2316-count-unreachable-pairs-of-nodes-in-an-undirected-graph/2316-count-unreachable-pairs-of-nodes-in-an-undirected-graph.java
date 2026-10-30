class Solution {

    static int[] parent;
    static int[] rank;

    public long countPairs(int n, int[][] edges) {

        if(edges.length == 0) {
            return (long) n * (n - 1) / 2;
        }

        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        Map<Integer, Integer> parentCount = new HashMap<>();

        for(int u = 0; u < n; u++) {
            int pu = find(u);
            parentCount.put(pu, parentCount.getOrDefault(pu, 0) + 1);
        }

        long count = 0;
        long remaining = n;

        for(int size : parentCount.values()) {
            count += (long) size * (remaining - size);
            remaining -= size;
        }

        return count;
    }

    static int find(int u) {
        if(parent[u] != u) {
            parent[u] = find(parent[u]);
        }

        return parent[u];
    }

    static void union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return;

        if(rank[pu] < rank[pv]) {
            parent[pu] = pv;
        }
        else if(rank[pu] > rank[pv]) {
            parent[pv] = pu;
        }
        else {
            parent[pu] = pv;
            rank[pv]++;
        }
    }
}