class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;

        boolean[] used = new boolean[nums.length];

        return backtrack(nums, used, k, 0, target, 0);
    }

    private boolean backtrack(int[] nums, boolean[] used,
                              int k, int currentSum,
                              int target, int start) {

       
        if (k == 1) {
            return true;
        }

       
        if (currentSum == target) {
            return backtrack(nums, used, k - 1,
                             0, target, 0);
        }

        for (int i = start; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            if (currentSum + nums[i] > target) {
                continue;
            }
            used[i] = true;
            if (backtrack(nums, used, k,
                          currentSum + nums[i],
                          target, i + 1)) {
                return true;
            }
            used[i] = false;
            // while (i + 1 < nums.length &&
            //        nums[i] == nums[i + 1]) {
            //     i++;
            // }
            if (currentSum == 0) {
                return false;
            }
        }
        return false;
    }
}