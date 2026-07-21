class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int left = 1;
        int right = Integer.MIN_VALUE;
        for(int val:nums){
        
            right = Math.max(right, val);
        }

        int result = 0;
        while(left <= right){
            int mid = left + (right - left)/2;

            int cost = 0;
            for(int num:nums){
                cost += Math.ceil((double) num / mid);
            }

            if(cost <= threshold){
                result = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return result;
    }
}