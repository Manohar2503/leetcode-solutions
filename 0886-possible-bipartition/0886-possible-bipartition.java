class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int m = dislikes.length;
        List<Integer>[] adjList = new ArrayList[n+1];
        for(int i=0;i<=n;i++) adjList[i] = new ArrayList<>();

        for(int[] dislike: dislikes){
            int u = dislike[0];
            int v = dislike[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }
        int[] color = new int[n+1];
        for(int i=1;i<=n;i++){
            if(color[i] ==0){
                if(!dfs(i, adjList, color, 1)) return false;
            }
        }
        return true;
    }

    static boolean dfs(int index, List<Integer>[] adjList, int[] color, int c){
        color[index] = c;
        for(int node: adjList[index]){
            if(color[node] == 0){
                if(!dfs(node, adjList, color, -c)) return false;
            }
            else if(color[node] == c) return false;
        }
        return true;
    }
}