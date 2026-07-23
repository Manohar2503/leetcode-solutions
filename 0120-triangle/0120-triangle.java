class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++){
        for(int j =0;j<=i;j++){
            dp[i][j]= Integer.MIN_VALUE;
        }
        }
        return minimumCost(0,0,triangle,dp);

    }
    public static int minimumCost(int i,int j,List<List<Integer>> triangle,int[][] dp){
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!= Integer.MIN_VALUE) return dp[i][j];
        int left = triangle.get(i).get(j) + minimumCost(i+1,j,triangle,dp);
        int right = triangle.get(i).get(j) + minimumCost(i+1,j+1,triangle,dp);
        return dp[i][j] = Math.min(left,right);
    }
}