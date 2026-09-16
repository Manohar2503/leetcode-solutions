class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left =0;
        int right =0;

        while(right < n){
            if(nums[left] != nums[right]){
                left++;
                nums[left] = nums[right];
            }
            right++;
        }

        return left+1;
    }
}

/*
        0 1 2 3 4 5 6 7 8 9 
        0 1 2 3 4 2 2 3 3 4
                 L         R

        1  1  2
           L  R
*/