
class Solution {
    public int slidingPuzzle(int[][] board) {

        String target = "123450";

        String start = convert(board);

        if (start.equals(target)) return 0;

        int[][] adj = {
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
        };

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start);

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                if (current.equals(target)) {
                    return steps;
                }

                int zero = current.indexOf('0');

                for (int next : adj[zero]) {

                    StringBuilder sb =
                        new StringBuilder(current);

                    // Swap zero with adjacent tile
                    char temp = sb.charAt(zero);

                    sb.setCharAt(zero, sb.charAt(next));
                    sb.setCharAt(next, temp);

                    String nextState = sb.toString();

                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        queue.offer(nextState);
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private String convert(int[][] board) {

        StringBuilder sb = new StringBuilder();

        for (int[] row : board) {
            for (int val : row) {
                sb.append(val);
            }
        }

        return sb.toString();
    }
}
