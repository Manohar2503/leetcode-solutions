class Solution {
    static int MOD = 1_000_000_007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] dp = new Integer[m][n][maxMove+1];
        return paths(startRow, startColumn, m, n, maxMove,dp);
    }
    static int paths(int r, int c, int m, int n, int maxMove, Integer[][][] dp){
        if(r<0 || c<0 || r>=m || c>=n) return 1;
        if(maxMove <=0) return 0;
        if(dp[r][c][maxMove]!=null) return dp[r][c][maxMove];

        long left = paths(r,c-1, m,n,maxMove-1,dp) % MOD;
        long right= paths(r,c+1, m,n,maxMove-1,dp) % MOD;
        long up =   paths(r-1,c, m,n,maxMove-1,dp) % MOD;
        long down = paths(r+1,c, m,n,maxMove-1,dp) % MOD;

        int result =(int) ((left + right + up + down) % MOD);
        return dp[r][c][maxMove] = result;
    }
}