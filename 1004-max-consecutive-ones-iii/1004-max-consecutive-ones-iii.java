class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left =0;
        int result =0;
        int zeroCount =0;

        for(int right =0;right<n;right++){
            if(nums[right] == 0) zeroCount++;
            if(zeroCount >k){
                while(nums[left]!=0) left++;
                left++;
                zeroCount--;
            }
            result = Math.max(result, right - left+1);
        }

        return result;        
    }
}
/*
    0 1 2 3 4 5 6 7 8 9 10
    1 1 1 0 0 0 1 1 1 1 0
            L         R
*/