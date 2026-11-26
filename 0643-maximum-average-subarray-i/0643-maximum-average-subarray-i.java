class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double result = 0;
        double current =0;

        for(int i=0;i<k;i++){
            current += nums[i];
        }
        result = current/k;

        for(int i=k;i<n;i++){

            current -= nums[i - k];
            current += nums[i];

            result = Math.max(result, (current / k));
        }

        return result;
    }
}