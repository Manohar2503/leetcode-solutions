
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;

        int[] up = new int[n];
        int[] down = new int[n];

        Arrays.fill(up, 1);
        Arrays.fill(down, 1);

        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } 
                else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }

            }

            maxLen = Math.max(maxLen, Math.max(up[i], down[i]));
        }

        return maxLen;
    }
}
