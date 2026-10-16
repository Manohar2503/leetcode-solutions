class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();

        for (int bus = 0; bus < routes.length; bus++) {
            for (int stop : routes[bus]) {
                stopToBuses.computeIfAbsent(
                    stop, k -> new ArrayList<>()
                ).add(bus);
            }
        }

        if (!stopToBuses.containsKey(source) ||
            !stopToBuses.containsKey(target)) {
            return -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        boolean[] visitedBuses = new boolean[routes.length];

        queue.offer(source);
        visitedStops.add(source);

        int busesTaken = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            busesTaken++;

            for (int i = 0; i < size; i++) {
                int stop = queue.poll();

                for (int bus : stopToBuses.get(stop)) {
                    if (visitedBuses[bus]) continue;

                    visitedBuses[bus] = true;

                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) {
                            return busesTaken;
                        }

                        if (visitedStops.add(nextStop)) {
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }

        return -1;
    }
}