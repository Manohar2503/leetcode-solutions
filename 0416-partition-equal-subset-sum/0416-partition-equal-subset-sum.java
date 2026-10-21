class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;

        for(int num: nums) total += num;
        int target = total /2;
        if(total % 2 !=0) return false;

        boolean[] isPossible = new boolean[target+1];
        isPossible[0] = true;

        for(int num: nums){
            for(int sum = target; sum>=num; sum--){
                isPossible[sum] = isPossible[sum] || isPossible[sum - num];
            }
            if(isPossible[target]) return true;
        }

        return isPossible[target];
    }
}
