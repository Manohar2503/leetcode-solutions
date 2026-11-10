class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int max = 0;

        for(int num: nums){
            max = Math.max(max, num);
        }

        int left = 1;
        int right = max;
        //int result =0;
        
        while(left < right){
            int mid = left + (right - left)/2;

            int value = 0;
            for(int num: nums){
                value += (int) Math.ceil((double) num/mid);
            }

            if(value>threshold){
                left = mid+1;
            }
            else right = mid;
        }

        return left;
    }
}