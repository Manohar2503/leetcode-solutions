class Solution {
    static int[] parent;
    static int[] rank;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n+1];
        rank = new int[n+1];

        for(int i=0;i<=n;i++){
            parent[i] =i;
            rank[i]=1;
        }

        int connectedroups = n;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1){
                    if(find(i) != find(j)){
                        union(i,j);
                        connectedroups--;
                    }
                }
            }
        }

        return connectedroups;
    }

    static int find(int u){
        if(parent[u] == u) return u;
        parent[u] = find(parent[u]);
        return parent[u];
    }

    static void union(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return;
        if(rank[pu] < rank[pv]){
            parent[pu] = pv;
        }
        else if(rank[pu] > rank[pv]){
            parent[pv] = pu;
        }
        else{
            parent[pu] = pv;
            rank[pv] = rank[pv]+1;
        }
    }
}