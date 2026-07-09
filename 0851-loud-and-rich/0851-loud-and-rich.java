import java.util.*;

class Solution {

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int n = quiet.length;

        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // poorer -> richer
        for (int[] edge : richer) {
            graph[edge[1]].add(edge[0]);
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int i = 0; i < n; i++) {
            dfs(i, graph, quiet, result);
        }

        return result;
    }

    private int dfs(int person,
                    List<Integer>[] graph,
                    int[] quiet,
                    int[] result) {

        // Already computed
        if (result[person] != -1) {
            return result[person];
        }

        // Initially assume this person is the answer
        result[person] = person;

        // Check every richer person
        for (int richerPerson : graph[person]) {

            int candidate = dfs(richerPerson, graph, quiet, result);

            if (quiet[candidate] < quiet[result[person]]) {
                result[person] = candidate;
            }
        }

        return result[person];
    }
}