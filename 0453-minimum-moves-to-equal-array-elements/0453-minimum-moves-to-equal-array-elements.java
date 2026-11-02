class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.sort(nums);
        int min = nums[0];

        for(int i=1;i<n;i++){
            int val = nums[i] - min;
            dp[i] = dp[i-1]+val;
        }

        return dp[n-1];
    }
}