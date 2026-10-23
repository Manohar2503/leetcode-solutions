class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int bit = -1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i) {
                if(bit == -1) bit = nums[i];   
                else bit &= nums[i];
            }
        }

        return (bit == -1)?0:bit;
    }
}
/*
        1 0 0 
        0 1 1

*/
