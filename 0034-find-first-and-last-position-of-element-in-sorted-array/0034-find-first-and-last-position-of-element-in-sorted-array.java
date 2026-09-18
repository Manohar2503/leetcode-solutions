class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{binary(nums, target, true), binary(nums, target, false)};
    }
    static int binary(int[] nums, int target, boolean isLeft){
        int n = nums.length;
        int left =0;
        int right = n-1;
        int index = -1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                index = mid;
                if(isLeft) right = mid-1;
                else left = mid +1;
            }
            else if(nums[mid] < target){
                left = mid +1;
            }
            else right = mid -1;
        }

        return index;
    }
}