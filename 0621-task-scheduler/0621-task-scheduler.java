class Solution {
    static class Node {
        char c;
        int count;
        int availableTime;

        Node(char c, int count, int availableTime) {
            this.c = c;
            this.count = count;
            this.availableTime = availableTime;
        }
    }

    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Most frequent task first
        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> b.count - a.count);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue(), 0));
        }

        Queue<Node> cooldown = new LinkedList<>();

        int time = 0;

        while (!pq.isEmpty() || !cooldown.isEmpty()) {

            // Move tasks whose cooldown is finished back to heap
            while (!cooldown.isEmpty()
                    && cooldown.peek().availableTime <= time) {

                pq.offer(cooldown.poll());
            }

            if (!pq.isEmpty()) {

                Node current = pq.poll();

                current.count--;

                if (current.count > 0) {
                    current.availableTime = time + n + 1;
                    cooldown.offer(current);
                }
            }

            time++;
        }

        return time;
    }
}