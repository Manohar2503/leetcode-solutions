class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (total % k != 0) {
            return false;
        }

        int target = total / k;

        // Sort in descending order
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        if (nums[0] > target) {
            return false;
        }

        int[] subsets = new int[k];

        return backtrack(nums, subsets, 0, target);
    }

    private boolean backtrack(
            int[] nums, int[] subsets, int index, int target) {

        if (index == nums.length) {
            return true;
        }

        for (int i = 0; i < subsets.length; i++) {

            // Skip equivalent subset states
            if (i > 0 && subsets[i] == subsets[i - 1]) {
                continue;
            }

            if (subsets[i] + nums[index] <= target) {
                subsets[i] += nums[index];

                if (backtrack(nums, subsets, index + 1, target)) {
                    return true;
                }

                subsets[i] -= nums[index];
            }

            // No need to try other empty subsets
            if (subsets[i] == 0) {
                break;
            }
        }

        return false;
    }
}