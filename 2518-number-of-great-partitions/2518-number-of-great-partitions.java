import java.util.Arrays;

class Solution {
    public int countPartitions(int[] nums, int k) {
        final int MOD = 1_000_000_007;

        long total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total < 2L * k) {
            return 0;
        }

        // dp[s] = number of subsets with sum s
        int[] dp = new int[k];
        dp[0] = 1;

        for (int num : nums) {
            for (int s = k - 1; s >= num; s--) {
                dp[s] = (int) (
                    (dp[s] + (long) dp[s - num]) % MOD
                );
            }
        }

        long bad = 0;
        for (int s = 0; s < k; s++) {
            bad = (bad + dp[s]) % MOD;
        }

        long all = 1;
        for (int i = 0; i < nums.length; i++) {
            all = (all * 2) % MOD;
        }

        long answer = (all - 2 * bad % MOD + MOD) % MOD;
        return (int) answer;
    }
}