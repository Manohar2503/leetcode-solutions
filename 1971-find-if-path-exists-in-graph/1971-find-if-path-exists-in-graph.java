class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++) adj[i] = new ArrayList<>();
        
        for(int[] edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        Set<Integer> set = new HashSet<>();
        return dfs(source, destination, adj, set);
    }

    static boolean dfs(int source, int destination , List<Integer>[] adj, Set<Integer> set){
        if(source == destination) return true;
        set.add(source);
        for(int val: adj[source]){
            if(!set.contains(val)){
                if(dfs(val, destination, adj, set)) return true;
            }
        }

        return false;
    }
}