class Solution {
    Integer[] dp;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        dp = new Integer[n];

        return solve(0, arr, k);
    }

    private int solve(int index, int[] arr, int k) {

        if (index == arr.length) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int maxVal = 0;
        int ans = 0;

        for (int len = 1; len <= k && index + len <= arr.length; len++) {

            maxVal = Math.max(maxVal, arr[index + len - 1]);

            int currentSum = maxVal * len;

            int remainingSum = solve(index + len, arr, k);

            ans = Math.max(ans, currentSum + remainingSum);
        }

        return dp[index] = ans;
    }
}