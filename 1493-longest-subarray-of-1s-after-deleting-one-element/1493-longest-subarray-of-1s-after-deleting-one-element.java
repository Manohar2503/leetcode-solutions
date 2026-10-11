class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left =0;
        int zero_count =0;
        int result =0;

        for(int right =0;right < n; right++){

            if(nums[right] == 0) zero_count++;

            while(zero_count > 1){
                if(nums[left] ==0) zero_count--;
                left++;
            }
            result = Math.max(result, right-left);
            System.out.print(result +" ");
        }

        result = Math.max(result, n - left-1);
        return result;
    }
}
/**     
                        R
        0 1 2 3 4 5 6 7 8 
        0 1 1 1 0 1 1 0 1
                  L


    zero_count = 1

 */