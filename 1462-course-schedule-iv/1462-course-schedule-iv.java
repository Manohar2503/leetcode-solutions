
import java.util.*;

class Solution {
    public List<Boolean> checkIfPrerequisite(
            int numCourses,
            int[][] prerequisites,
            int[][] queries) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            adj.get(p[0]).add(p[1]);
        }

        List<Boolean> answer = new ArrayList<>();

        for (int[] q : queries) {
            boolean[] visited = new boolean[numCourses];

            answer.add(dfs(q[0], q[1], adj, visited));
        }

        return answer;
    }

    private boolean dfs(int src, int dest,
                        List<List<Integer>> adj,
                        boolean[] visited) {

        visited[src] = true;

        for (int next : adj.get(src)) {
            if (next == dest) {
                return true;
            }

            if (!visited[next]) {
                if (dfs(next, dest, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
