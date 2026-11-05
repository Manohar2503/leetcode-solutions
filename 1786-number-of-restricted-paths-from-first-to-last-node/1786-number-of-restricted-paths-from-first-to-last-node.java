class Solution {
    static final int MOD = 1_000_000_007;

    public int countRestrictedPaths(int n, int[][] edges) {

        List<int[]>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        // Step 1: Dijkstra from node n

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[1], b[1])
        );

        dist[n] = 0;
        pq.offer(new long[]{n, 0});

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            int u = (int) curr[0];
            long d = curr[1];

            if (d > dist[u]) continue;

            for (int[] edge : adj[u]) {

                int v = edge[0];
                long nd = d + edge[1];

                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new long[]{v, nd});
                }
            }
        }

        // Step 2: Sort nodes by increasing distance

        Integer[] nodes = new Integer[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = i + 1;
        }

        Arrays.sort(nodes, (a, b) ->
            Long.compare(dist[a], dist[b])
        );

        // Step 3: DP

        int[] dp = new int[n + 1];

        dp[n] = 1;

        for (int u : nodes) {

            if (u == n) continue;

            long ways = 0;

            for (int[] edge : adj[u]) {

                int v = edge[0];

                if (dist[u] > dist[v]) {
                    ways += dp[v];
                    ways %= MOD;
                }
            }

            dp[u] = (int) ways;
        }

        return dp[1];
    }
}