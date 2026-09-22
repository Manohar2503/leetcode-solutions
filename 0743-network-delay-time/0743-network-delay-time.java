import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] arr : times) {
            adj.get(arr[0]).add(new int[]{arr[1], arr[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int node = temp[0];
            int time = temp[1];

            if (time > dist[node]) continue;

            for (int[] sub : adj.get(node)) {
                int next = sub[0];
                int weight = sub[1];
                int newDist = time + weight;
                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    pq.offer(new int[]{next, newDist});
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}