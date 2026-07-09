class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] adj = new ArrayList[n];
        for(int i =0;i <n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] arr: richer){
            adj[arr[1]].add(arr[0]);
        }
        int[] result = new int[n]; 
        for(int i=0;i<n;i++){
            result[i] = bfs(i, adj, quiet);
        }
        return result;
    }

    static int bfs(int index, List<Integer>[] adj, int[] quiet){
        int person = index;
        int quieter = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        q.offer(index);

        Set<Integer> set = new HashSet<>();
        set.add(index);
        while(!q.isEmpty()){
            int cu = q.poll();
            if(quiet[cu] < quieter) {
                person = cu;
                quieter = quiet[cu];
            }
            for(int node: adj[cu]){
                if(!set.contains(node)){
                    q.offer(node);
                    set.add(node);
                }
            }
        }
        return person;
    }
}