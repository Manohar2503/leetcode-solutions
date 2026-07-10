class Solution {
    int[] parent;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(dislikes.length ==0) return true;
        List<Integer>[] adj = new ArrayList[n+1];
        parent = new int[n+1];
        for(int i=0;i<=n;i++) parent[i]=i;
        for(int i=0;i<=n;i++) adj[i] = new ArrayList<>();
        for(int[] dislike : dislikes){
            int u = dislike[0];
            int v = dislike[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        for(int i=1;i<=n;i++){
            if (adj[i].isEmpty()) continue;
            int first = adj[i].get(0);
            for(int v:adj[i]){
                if(find(v)==find(i)) return false;
                parent[v]= first;
            }
        }
        return true;
    }


    private int find(int node){
        if(parent[node]!=node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }
}