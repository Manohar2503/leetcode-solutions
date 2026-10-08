class Solution {

    static class Node {
        int u;
        int v;
        int dis;
        Set<Node> connectedNodes;

        Node(int u, int v, int dis) {
            this.u = u;
            this.v = v;
            this.dis = dis;
            connectedNodes = new HashSet<>();
        }
    }

    public int maximumDetonation(int[][] bombs) {

        List<Node> nodes = new ArrayList<>();

        for (int[] bomb : bombs) {
            nodes.add(new Node(bomb[0], bomb[1], bomb[2]));
        }

        for (Node node1 : nodes) {
            for (Node node2 : nodes) {
                
                if (node1 == node2) continue;
                long dx = node1.u - node2.u;
                long dy = node1.v - node2.v;

                long distanceSquared = dx * dx + dy * dy;
                if (distanceSquared <= (long) node1.dis * node1.dis) {
                    node1.connectedNodes.add(node2);
                }

            }
        }

        int result = 0;
        for (Node node : nodes) {
            Set<Node> visited = new HashSet<>();
            dfs(node, visited);
            result = Math.max(result, visited.size());
        }
        return result;
    }

    private void dfs(Node node, Set<Node> visited) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);
        for (Node next : node.connectedNodes) {
            dfs(next, visited);
        }
    }
}