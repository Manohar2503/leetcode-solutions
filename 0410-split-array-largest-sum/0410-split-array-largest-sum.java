class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int min = 0;
        int max = 0;
        for(int ele: nums){
            min = Math.max(min, ele);
            max += ele;
        }
        int left = min;
        int right = max;

        int result = 0;
        while(left <= right ){
            int mid = left + (right - left)/2;
            if(possible(nums,k,mid)){
                result = mid;
                right = mid -1;
            }
            else{
                
                left = mid +1;
            }
        }

        return result;
    }

    static boolean possible(int[] nums, int k, int mid){
        int newk =1;
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(count + nums[i] <=mid) count += nums[i];
            else{
                count = nums[i];
                newk++;
            }
        }
        return (newk<=k)?true:false;
    }
}