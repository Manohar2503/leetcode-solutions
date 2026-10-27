class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }

        return f(0,0,dungeon,n,m,dp);
    }

    public static int f(int i, int j, int[][] arr, int row, int col,int[][] dp){
        if(i==row-1 && j==col-1){
            return arr[i][j]<=0? 1+Math.abs(arr[i][j]):1;
        }
        if(i>=row || j>=col){
            return (int)1e9;
        }
        if(dp[i][j]!=-1) return dp[i][j];

        int down = f(i+1,j,arr,row,col,dp);
        int right =f(i,j+1,arr,row,col,dp);

        int nextHealth =  Math.min(down,right);
        return dp[i][j] = Math.max(1, nextHealth - arr[i][j]);

    }
}