class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int result =0;

        int zero_count =0;
        int left =0;

        for(int right=0; right<n; right++){
            if(nums[right] == 0) zero_count++;
            if(zero_count == 2){
                while(nums[left]!=0) left++;
                left++;
                zero_count--;
            }

            result = Math.max(result, right - left +1);
        }

        return result-1;
    }
}