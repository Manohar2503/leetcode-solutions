class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] list = new int[n];
        int r =0;
        list[r] = nums[0];
        r++;
        for(int i=1;i<n;i++){
            int j = r-1;
            while(j>=0 && list[j] >= nums[i]){
                j--;
            }
            j++;
            list[j] = nums[i];
            r = j>=r?j+1:r;
        }
        return r;
    }
}
/**

        10 9 2 5 3 7 101 18
                      i 
               0 1 2  3
        list : 2 3 7 18
                      j

 */