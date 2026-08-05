class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int totalSum =0;
        int max = 0;
        for(int val: nums){
            max = Math.max(max, val);
            totalSum += val;
        }
        
        int left =max;
        int right = totalSum;
        int result =0;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(isPossible(mid, nums, k)){
                result = mid;
                right = mid -1;
            }
            else{
                
                left = mid+1;
            }
        }

        return result;
    }

    static boolean isPossible(int mid, int[] nums, int k){
        int splits =1;
        int currentSum =0;

        for(int i=0;i<nums.length;i++){
            if(currentSum + nums[i] <= mid){
                currentSum = currentSum + nums[i];
            }
            else{
                splits++;
                System.out.print(splits+" ");
                currentSum = nums[i];
            }
        }

        return (k>=splits)?true:false;
    }
}