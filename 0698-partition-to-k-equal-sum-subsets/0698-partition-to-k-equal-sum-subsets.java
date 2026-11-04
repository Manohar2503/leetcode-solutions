class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % k != 0) return false;

        int target = sum / k;

        Arrays.sort(nums);

        if (nums[nums.length - 1] > target) return false;

        return backtrack(nums, 0, k, 0, 0, target);
    }

    private boolean backtrack(int[] nums, int mask,
                              int k, int start, int currentSum,
                              int target) {

        if (k == 1) return true;

        if (currentSum == target) {
            return backtrack(nums, mask, k - 1, 0, 0, target);
        }

        for (int i = start; i < nums.length; i++) {

            int pos = 1 << i;

            if ((mask & pos) != 0 ||
                currentSum + nums[i] > target) {
                continue;
            }

            mask |= pos;

            if (backtrack(nums, mask, k, i + 1,
                          currentSum + nums[i], target)) {
                return true;
            }

            mask &= ~pos;
        }

        return false;
    }
}