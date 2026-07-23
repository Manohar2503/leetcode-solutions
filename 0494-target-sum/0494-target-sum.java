class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int num: nums) total += num;

        if(total - Math.abs(target) <0) return 0;
        return helper(0,0,nums, target);

    }

    static int helper(int index, int sum, int[] nums, int target){
        if(index == nums.length){
            if(sum == target) return 1;
             return 0;
        }

        int count =0;
        count += helper(index+1, sum + nums[index], nums, target);
        count += helper(index+1, sum - nums[index], nums, target);

        return count;
    }
}