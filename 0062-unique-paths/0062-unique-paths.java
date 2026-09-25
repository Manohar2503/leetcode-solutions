class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return paths(0,0,m,n,dp);
    }
    static int paths(int r, int c, int m , int n, int[][] dp){
        if(r<0 || r>=m || c<0 || c>=n) return 0;
        if(r==m-1 && c == n-1) return 1;
        if(dp[r][c] !=-1) return dp[r][c];
        int count =0;
        count += paths(r+1, c, m, n, dp);
        count += paths(r, c+1, m, n, dp);

        return dp[r][c] = count;
    }
}