class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        int prevDiff = nums[1] - nums[0];
        int count = 0;
        int total = 0;

        for (int right = 2; right < n; right++) {
            int diff = nums[right] - nums[right - 1];

            if (diff == prevDiff) {
                count++;
                total += count;
            } else {
                count = 0;
                prevDiff = diff;
            }
        }

        return total;
    }
}