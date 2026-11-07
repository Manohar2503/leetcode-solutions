class Solution {
    public int maxSubArray(int[] nums) {
        int max_Sum = Integer.MIN_VALUE;
        int curr =0;
        for(int val: nums){
            curr = Math.max(curr + val, val);
            max_Sum = Math.max(max_Sum, curr);
        }

        return max_Sum;
    }
}
/*
                 i
    -2,1,-3,4,-1,2,1,-5,4

    current = -1
    max = -1
    result = 4

*/