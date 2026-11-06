
class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";

        Set<String> deadEnd = new HashSet<>(Arrays.asList(deadends));

        if (deadEnd.contains(start)) return -1;
        if (target.equals(start)) return 0;

        Set<String> visited = new HashSet<>();
        Queue<String> qu = new LinkedList<>();

        qu.offer(start);
        visited.add(start);

        int steps = 0;

        while (!qu.isEmpty()) {
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                String str = qu.poll();

                if (str.equals(target)) return steps;

                StringBuilder current = new StringBuilder(str);

                for (int j = 0; j < 4; j++) {
                    int val = current.charAt(j) - '0';

                    int pos1 = (val - 1 + 10) % 10;
                    int pos2 = (val + 1) % 10;

                    // Rotate backward
                    current.setCharAt(j, (char) (pos1 + '0'));

                    String next = current.toString();

                    if (!deadEnd.contains(next) && !visited.contains(next)) {
                        qu.offer(next);
                        visited.add(next);
                    }

                    // Rotate forward
                    current.setCharAt(j, (char) (pos2 + '0'));

                    next = current.toString();

                    if (!deadEnd.contains(next) && !visited.contains(next)) {
                        qu.offer(next);
                        visited.add(next);
                    }

                    // Restore original digit
                    current.setCharAt(j, (char) (val + '0'));
                }
            }

            steps++;
        }

        return -1;
    }
}
