class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1_000_000_007;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i <= high; i++) {
            int ways = 0;
            if (i >= zero) ways = dp[i - zero];
            if (i >= one) ways = (ways + dp[i - one]) % mod;
            dp[i] = ways;
            if (i >= low) ans = (ans + ways) % mod;
        }
        return ans;
    }
}