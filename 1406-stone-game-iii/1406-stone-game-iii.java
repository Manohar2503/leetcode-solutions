
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            dp[i] = Integer.MIN_VALUE;

            int sum = 0;

            for (int x = 1; x <= 3 && i + x <= n; x++) {

                sum += stoneValue[i + x - 1];

                int current = sum - dp[i + x];

                dp[i] = Math.max(dp[i], current);
            }
        }

        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";

        return "Tie";
    }
}
