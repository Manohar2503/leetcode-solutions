class Solution {
    public int minScoreTriangulation(int[] values) {
int n=values.length;
        int[][]dp=new int[n][n];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,n-1,values,dp);
    }
    private int solve(int i,int j,int[]values,int[][]dp){
        if(j-i<2)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int score=values[i]*values[j]*values[k]+solve(i,k,values,dp)+solve(k,j,values,dp);
            min=Math.min(min,score);
        }
        return dp[i][j]=min;
    }
}