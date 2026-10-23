
import java.util.Arrays;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);

        return combinations(target, nums, dp);
    }

    static int combinations(int target, int[] nums, int[] dp) {
        if (target == 0) return 1;
        if (target < 0) return 0;

        if (dp[target] != -1) return dp[target];

        int ways = 0;

        for (int num : nums) {
            ways += combinations(target - num, nums, dp);
        }

        return dp[target] = ways;
    }
}
