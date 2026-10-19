class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int MOD = 1_000_000_007;

        int[] dp = new int[high + 1];
        dp[0] = 1;

        int ans = 0;

        for (int i = 0; i <= high; i++) {
            if (i >= low) {
                ans = (int) ((ans + (long) dp[i]) % MOD);
            }

            if (i + zero <= high) {
                dp[i + zero] = (int) (
                    (dp[i + zero] + (long) dp[i]) % MOD
                );
            }

            if (i + one <= high) {
                dp[i + one] = (int) (
                    (dp[i + one] + (long) dp[i]) % MOD
                );
            }
        }

        return ans;
    }
}