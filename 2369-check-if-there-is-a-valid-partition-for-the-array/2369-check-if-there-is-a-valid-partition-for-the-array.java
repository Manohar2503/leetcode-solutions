class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n];

        return partition(0, nums, dp);
    }

    static boolean partition(int index, int[] nums, Boolean[] dp) {
        int n = nums.length;

        if(index == n) return true;

        if(dp[index] != null) return dp[index];

        boolean result = false;

        // Two equal elements
        if(index + 1 < n &&
           nums[index] == nums[index + 1]) {
            result = partition(index + 2, nums, dp);
        }

        // Three elements
        if(index + 2 < n) {

            // Three equal elements
            if(nums[index] == nums[index + 1] &&
               nums[index + 1] == nums[index + 2]) {

                result |= partition(index + 3, nums, dp);
            }

            // Three consecutive increasing elements
            if(nums[index] + 1 == nums[index + 1] &&
               nums[index + 1] + 1 == nums[index + 2]) {

                result |= partition(index + 3, nums, dp);
            }
        }

        return dp[index] = result;
    }
}