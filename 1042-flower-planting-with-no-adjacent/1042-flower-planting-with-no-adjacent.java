class Solution {

    public int[] gardenNoAdj(int n, int[][] paths) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : paths) {

            int u = edge[0] - 1;
            int v = edge[1] - 1;

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {

            boolean[] used = new boolean[5];

            // Mark flowers used by neighbours
            for (int neighbour : graph[i]) {
                used[answer[neighbour]] = true;
            }

            // Pick the first available flower
            for (int flower = 1; flower <= 4; flower++) {
                if (!used[flower]) {
                    answer[i] = flower;
                    break;
                }
            }
        }

        return answer;
    }
}