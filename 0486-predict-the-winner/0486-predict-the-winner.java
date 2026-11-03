class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        Integer[][] dp = new Integer[n][n];

        return minmax(0, n - 1, nums, dp) >= 0;
    }

    static int minmax(int i, int j, int[] nums, Integer[][] dp) {

        if (i == j) {
            return nums[i];
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int left = nums[i] - minmax(i + 1, j, nums, dp);

        int right = nums[j] - minmax(i, j - 1, nums, dp);

        return dp[i][j] = Math.max(left, right);
    }
}