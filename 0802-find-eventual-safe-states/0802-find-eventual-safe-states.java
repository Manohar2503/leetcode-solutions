class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // terminal - node with out degree
        // safe = terminal node or all paths from lead to terminal node

        int V = graph.length;

        int[] vis = new int[V];

        for(int u = 0; u < V; u++){
            if(vis[u] == 0){
                DFS(u, graph, vis);
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int u = 0; u < V; u++){
            if(vis[u] != 2){
                list.add(u);
            }
        }

        return list;
    }

    public boolean DFS(int u, int[][] graph, int[] vis){
        vis[u] = 2;

        for(int v : graph[u]){
            if(vis[v] == 0){
                if(DFS(v, graph, vis))
                    return true;
            }
            else if(vis[v] == 2){
                return true;
            }
        }
        vis[u] = 1;
        return false;
    }
}