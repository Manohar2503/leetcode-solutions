class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n];
        return partition(0, n, nums, dp);
    }

    static boolean partition(int index, int n, int[] nums, Boolean[] dp){
        if(index >= n) return true;

        if(dp[index]!=null) return dp[index];
        boolean part1 = false;
        if(index+1<n){
            if(nums[index]==nums[index+1]){
                part1 = partition(index+2, n, nums,dp);
            }
        }

        boolean part2 = false;
        if(index+2 < n){
            if(nums[index]== nums[index+1] && nums[index] == nums[index+2]){
                part2 = partition(index+3, n, nums,dp);
            }

            else if(nums[index+1]==nums[index]+1 && nums[index+2]==nums[index]+2){
                part2 |= partition(index+3, n, nums,dp);
            }
        }


        return dp[index] = part1 || part2;
    }
}