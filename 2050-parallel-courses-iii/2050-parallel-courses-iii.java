import java.util.*;

class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        
        int[] indegree = new int[n + 1];
        
        // Build graph correctly
        for (int[] r : relations) {
            int u = r[0], v = r[1];
            adj[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[n + 1];

        // Initialize
        for (int i = 1; i <= n; i++) {
            dp[i] = time[i - 1];
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int result = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            result = Math.max(result, dp[u]);

            for (int v : adj[u]) {
                dp[v] = Math.max(dp[v], dp[u] + time[v - 1]);
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        return result;
    }
}