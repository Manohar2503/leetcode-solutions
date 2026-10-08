class Solution {
    boolean canAKillB(int[] a,int[] b){
        long dx = (long)a[0] - (long)b[0];
        long dy = (long)a[1] - (long)b[1];
        long dis = (long) dx*dx + (long) dy*dy;
        long radiusA = (long)a[2];
        return dis<=radiusA*radiusA;
    }

    void dfs(int node, Map<Integer,List<Integer>> adj, int[] vis, int[] count ){
        vis[node] = 1;
        count[0]++;
        for(int child : adj.getOrDefault(node,new ArrayList<>())){
            if(vis[child]==0)
                dfs(child,adj,vis,count);
        }
    }



    public int maximumDetonation(int[][] bombs) {
        //create adj
        Map<Integer,List<Integer>> adj = new HashMap<>();

        for(int i=0;i<bombs.length;i++){
            for(int j=0;j<bombs.length;j++){
                if(i!=j && canAKillB(bombs[i],bombs[j])){
                    adj.computeIfAbsent(i,k->new ArrayList<>()).add(j);
                }
            }
        }
        int ans = 1;
        for(int i=0;i<bombs.length;i++){
            int[] vis = new int[bombs.length];
            int[] count = new int[1];
            dfs(i,adj,vis,count);
            ans = Math.max(ans,count[0]);
        }

        return ans;

    }
}