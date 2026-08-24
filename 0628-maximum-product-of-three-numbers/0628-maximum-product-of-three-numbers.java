class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        if(n==3) return nums[0] * nums[1] * nums[2];

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for(int val: nums){
            if(max1 < val){
                max3 = max2;
                max2 = max1;
                max1 = val;
            }
            else if(max2 < val){
                max3 = max2;
                max2 = val;
            }
            else if(max3 < val){
                max3 = val;
            }

            if(min1 > val){
                min2 = min1;
                min1 = val;
            }
            else if(min2 > val){
                min2 = val;
            }
        }

        long product1  =1L* max1 * max2 * max3;
        long product2 = 1L * min1 * min2 * max1;

        return  (int)(product1 > product2? product1: product2);
    }
}