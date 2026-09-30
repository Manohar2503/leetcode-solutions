class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for(int i=0;i<n;i++){
            if(colors[i] ==0 && !dfs(i,1, graph, colors)) return false;
        }

        return true;
    }

    static boolean dfs(int currentNode, int color, int[][] graph, int[] colors){
        colors[currentNode] = color;
        for(int adjNode: graph[currentNode]){
           if(colors[adjNode] == 0) {
                if(!dfs(adjNode, -color, graph, colors)) return false;
           }
           else if(colors[adjNode] == color) return false;
        }
        return true;
    }
}
/*           1 -1  1      
            [0, 1, 2, 3]
    0 - 1
    | \ |
    3 - 2

*/
