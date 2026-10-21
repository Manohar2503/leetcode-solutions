class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];

        List<Integer> result = new ArrayList<>();

        for (int node = 0; node < n; node++) {
            if (dfs(node, graph, state)) {
                result.add(node);
            }
        }

        return result;
    }

    private boolean dfs(int node, int[][] graph, int[] state) {

        // Currently exploring this node: cycle found
        if (state[node] == 1) {
            return false;
        }

        // Already confirmed safe
        if (state[node] == 2) {
            return true;
        }

        // Mark as currently exploring
        state[node] = 1;

        // Every neighbor must be safe
        for (int next : graph[node]) {
            if (!dfs(next, graph, state)) {
                return false;
            }
        }

        // All neighbors are safe
        state[node] = 2;
        return true;
    }
}