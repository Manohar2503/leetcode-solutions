class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0];
        
        int maxEnding = nums[0];
        int maxSum = nums[0];

        int minEnding = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            totalSum += num;

            // Maximum subarray sum
            maxEnding = Math.max(num, maxEnding + num);
            maxSum = Math.max(maxSum, maxEnding);

            // Minimum subarray sum
            minEnding = Math.min(num, minEnding + num);
            minSum = Math.min(minSum, minEnding);
        }

        // All elements are negative: avoid an empty circular subarray.
        if (maxSum < 0) {
            return maxSum;
        }

        // Compare normal and circular maximum sums.
        return Math.max(maxSum, totalSum - minSum);
    }
}