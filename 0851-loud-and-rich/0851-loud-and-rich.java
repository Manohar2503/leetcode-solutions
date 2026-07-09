import java.util.*;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int n = quiet.length;

        List<Integer>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // richer -> poorer
        for (int[] edge : richer) {
            int rich = edge[0];
            int poor = edge[1];

            graph[rich].add(poor);
            indegree[poor]++;
        }

        // Initially everyone thinks they are the quietest.
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = i;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Start from richest people.
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int poorer : graph[current]) {

                // Propagate quieter person.
                if (quiet[answer[current]] < quiet[answer[poorer]]) {
                    answer[poorer] = answer[current];
                }

                indegree[poorer]--;

                if (indegree[poorer] == 0) {
                    queue.offer(poorer);
                }
            }
        }

        return answer;
    }
}