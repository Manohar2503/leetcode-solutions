class Solution {
    static int MOD = 1_000_000_007;
    public int numTilings(int n) {
        
        if(n == 0) return 0;
        if(n <= 2) return n;

        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = (2 * dp[i-1] + dp[i-3]) % MOD;
        }

        return (int)dp[n];
    }
}
/*

    n = 1
     
     # 
     #        ans = 1

    n = 2

    #  #
    #  #      ans = 2

    n = 3

    #  #  #
    #  #  #   ans = if(n % 3 ==0) ans +=2

    n = 4

    # # # #
    # # # #   ans = 6


*/