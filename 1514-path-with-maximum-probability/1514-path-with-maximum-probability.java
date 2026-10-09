class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb,
                                 int start_node, int end_node) {

        List<List<double[]>> adjNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjNodes.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjNodes.get(u).add(new double[]{v, succProb[i]});
            adjNodes.get(v).add(new double[]{u, succProb[i]});
        }

        PriorityQueue<double[]> pq =
            new PriorityQueue<>((a, b) ->
                Double.compare(b[1], a[1]));

        double[] probabilities = new double[n];
        probabilities[start_node] = 1.0;

        pq.offer(new double[]{start_node, 1.0});

        while (!pq.isEmpty()) {
            double[] current = pq.poll();
            int currentNode = (int) current[0];
            double currentProbability = current[1];

            if (currentProbability < probabilities[currentNode]) {
                continue;
            }

            if (currentNode == end_node) {
                return currentProbability;
            }

            for (double[] adj : adjNodes.get(currentNode)) {
                int nextNode = (int) adj[0];
                double edgeProbability = adj[1];

                double newProbability =
                    currentProbability * edgeProbability;

                if (newProbability > probabilities[nextNode]) {
                    probabilities[nextNode] = newProbability;

                    pq.offer(new double[]{
                        nextNode, newProbability
                    });
                }
            }
        }

        return 0.0;
    }
}
