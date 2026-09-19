class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left =0;
        int right = n-1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[right]){
                right = mid;
            }
            else left = mid+1;
        }

        return nums[left];
    }
}

/*


    0 1 2 3 4 5 6
    4 5 6 7 0 1 2
            LR



    0 1 2
    3 1 2
    L M R
*/