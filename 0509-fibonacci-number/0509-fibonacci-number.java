class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fabinoccies(n, dp);
    }

    static int fabinoccies(int n , int[] dp){
        if(n <=1) return n;

        if(dp[n]!=-1) return dp[n];
        dp[n] = fabinoccies(n-1, dp) + fabinoccies(n-2, dp);
        return dp[n];
    }
}