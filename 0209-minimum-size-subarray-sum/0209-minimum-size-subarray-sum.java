class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left =0;
        int right = 0;
        int sum =0;
        int min_length = n+1;

        while(right < n){
            sum += nums[right];
            while(left <= right && sum >= target){
                min_length = Math.min(min_length, right - left +1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return (min_length==n+1)?0:min_length;
    }
}
/*

      L
    2 3 1 2 4 3
          R

    sum = 9
*/