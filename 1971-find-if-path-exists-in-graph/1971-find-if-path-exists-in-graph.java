class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> qu = new LinkedList<>();
        Set<Integer> set = new HashSet();
        set.add(source);
        qu.offer(source);

        while(!qu.isEmpty()){
            int cur = qu.poll();
            if(cur == destination) return true;

            for(int node: adj.get(cur)){
                if(!set.contains(node)) {
                    qu.offer(node);
                    set.add(node);
                }
            }
        }
        return false;
    }
}