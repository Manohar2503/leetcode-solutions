class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dp = constructadj(n,edges);
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dp[i][k]!=Integer.MAX_VALUE && dp[k][j]!=Integer.MAX_VALUE){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                    }
                }
            }
        }
    int[] len = new int[n];
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                    if(dp[i][j]<=distanceThreshold){
                        count++;
                    }
            }
            len[i]=count;
        }
    int min = Integer.MAX_VALUE;
    int result=-1;
        for(int i=0;i<n;i++){
            if(min >= len[i]){
                min = len[i];
                result = i;
            }
        }
        return result;
    }

    static int[][] constructadj(int n, int[][] edges){
        int[][] dp = new int[n][n];
        for(int[] edge:dp){
            Arrays.fill(edge,Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            dp[i][i]=0;
        }
        for(int[] arr:edges){
            dp[arr[0]][arr[1]]=arr[2];
            dp[arr[1]][arr[0]]=arr[2];
        }
        return dp;
    }
}