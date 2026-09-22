class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++) adj[i] = new ArrayList<>();
        
        for(int[] edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        Queue<Integer> qu = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        set.add(source);

        qu.offer(source);
        while(!qu.isEmpty()){
            int u = qu.poll();
            if(u == destination) return true;
            for(int v: adj[u]){
                if(!set.contains(v)){
                    qu.offer(v);
                    set.add(v);
                }
            }
        }

        return false;
    }
}