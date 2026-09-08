class Solution {
    class Dsu{
        int parent[];
        Dsu(int n){
            parent= new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        int find(int node){
            if(parent[node]==node) return node;
            return parent[node]= find(parent[node]);
        }
        void union(int i, int j){
            int pi=find(i);
            int pj=find(j);
            parent[pi]=pj;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Dsu dsu= new Dsu(n);
        for(int x[]:edges){
            dsu.union(x[0],x[1]);
        }
        return dsu.find(source)==dsu.find(destination);
    }
}