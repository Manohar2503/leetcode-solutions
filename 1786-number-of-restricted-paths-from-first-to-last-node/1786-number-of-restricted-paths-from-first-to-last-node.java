
import java.util.*;

class Solution {

    private static final int MOD = 1_000_000_007;

    List<int[]>[] adj;
    int[] dist;
    int[] dp;
    int n;

    public int countRestrictedPaths(int n, int[][] edges) {

        this.n = n;

        adj = new ArrayList[n + 1];

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

        dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        dist[n] = 0;

        pq.offer(new int[]{n, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int node = curr[0];
            int weight = curr[1];

            if (weight > dist[node]) {
                continue;
            }

            for (int[] edge : adj[node]) {

                int next = edge[0];
                int newDist = weight + edge[1];

                if (newDist < dist[next]) {

                    dist[next] = newDist;

                    pq.offer(new int[]{next, newDist});
                }
            }
        }

        dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return dfs(1);
    }

    private int dfs(int node) {
        if (node == n) {
            return 1;
        }

        if (dp[node] != -1) {
            return dp[node];
        }

        long ways = 0;

        for (int[] edge : adj[node]) {

            int next = edge[0];

            if (dist[node] > dist[next]) {

                ways += dfs(next);

                ways %= MOD;
            }
        }

        return dp[node] = (int) ways;
    }
}