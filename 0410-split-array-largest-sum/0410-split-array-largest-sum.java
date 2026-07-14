class Solution {
    public int splitArray(int[] nums, int k) {
        int left=0;
        int right=0;
        int ans=right;
        for(int num:nums){
            left = Math.max(left,num);
            right +=num;
        }
        while(left <= right){
            int mid = left + (right- left )/2;
            if(isPossible(nums,k,mid)){
                ans=mid;
                right=mid-1;
            }
            else{
                left= mid+1;
            }
        }
        return ans;
    }
    static boolean isPossible(int[] arr, int k, int mid){
        int count=1;
        int val=0;
        for(int num:arr){
               if(val+num <=mid){
                val +=num;
               }
               else{
               count++;
               val=num;
               }   
        }
        if(count<=k){
            return true;
        }
        return false;
    }
}