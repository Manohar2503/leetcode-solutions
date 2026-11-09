class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        int left = 1;
        int right = 0;
        for(int num: nums) right = Math.max(right, num);

        int result =0;

        while(left <= right){
            int mid = left + (right - left)/2;

            long no = 0;
            for(int i=0;i<n;i++){
                int val = nums[i];
                no += (val-1)/mid;
            }

            if(no <= maxOperations) {
                result = mid;
                right = mid -1;
            }
            else left = mid+1;
        }

        return result;
    }
}
/* 

    1. I need to minimize the max ele in arr
    2. 

*/
