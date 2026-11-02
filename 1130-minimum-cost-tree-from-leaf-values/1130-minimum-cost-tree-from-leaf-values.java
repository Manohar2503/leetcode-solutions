class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n][n];

        for(int len=1;len<n;len++){
            for(int i=0;i+len<n;i++){
                int j = i+len;
                dp[i][j]=Integer.MAX_VALUE;

                int left =arr[i];

                for(int k = i;k<j;k++){
                    left = Math.max(left, arr[k]);
                    int right=0;
                    for(int index=k+1;index<=j;index++) right = Math.max(right, arr[index]);
                    int cost = dp[i][k] + dp[k+1][j] + left*right;
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n-1];
    }
}
/**

     conditions:
        1. i need to fix two numbers
        2. the two numbers should be  max


*/