class Solution {
    public int findDuplicate(int[] nums) {
       int n = nums.length;
       for(int i=0;i<n;i++){
         
         while(nums[i]!=i+1 && nums[i] != nums[nums[i]-1]){
            int index = nums[i]; // 4
            nums[i] = nums[index-1]; // 
            nums[index-1]= index; 
         }
       }

       for(int i=0;i<n;i++){
        if(nums[i]!=i+1) return nums[i];
       }
       return -1;
    }
}
/*


    1 3 4 2 2 - 1 3 4
    
    0 1 2 3 4
    1 2 3 4 2
            i

*/