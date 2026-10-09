
import java.util.*;

class Solution {
    public int minTime(int n, int[][] edges) {
        List<List<int[]>> adjNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjNodes.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int start = edge[2];
            int end = edge[3];

            adjNodes.get(u).add(new int[]{v, start, end});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a[1], b[1]));

        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int currentNode = current[0];
            int time = current[1];

            if (time > dist[currentNode]) {
                continue;
            }

            if (currentNode == n - 1) {
                return time;
            }

            for (int[] edge : adjNodes.get(currentNode)) {
                int nextNode = edge[0];
                int start = edge[1];
                int end = edge[2];

                if (time > end) {
                    continue;
                }

                int departureTime = Math.max(time, start);
                int arrivalTime = departureTime + 1;

                if (arrivalTime < dist[nextNode]) {
                    dist[nextNode] = arrivalTime;
                    pq.offer(new int[]{nextNode, arrivalTime});
                }
            }
        }

        return -1;
    }
}
