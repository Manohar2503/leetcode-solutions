class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        boolean[] vis = new boolean[n];
        int count =0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i,isConnected,vis);
            }
        }
        return count;
    }
    static void dfs(int index, int[][] isConnected, boolean[] vis){
        
        vis[index]= true;
        for(int i=0;i<isConnected[0].length;i++){
            if(index!=i && !vis[i] && isConnected[index][i]==1){
                dfs(i,isConnected,vis);
            }
        }
    }
}