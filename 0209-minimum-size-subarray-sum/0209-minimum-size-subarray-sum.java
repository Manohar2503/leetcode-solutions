class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res=Integer.MAX_VALUE;
        int i=0,j=0;
        int count=0;

        while(i<=j && j<nums.length){
            count += nums[j];
                while(count>=target){
                    res = Math.min(res,j-i+1);
                    count -=nums[i];
                    i++;
                }
            
            j++;
        }
        return (res==Integer.MAX_VALUE)?0:res;
    }
}