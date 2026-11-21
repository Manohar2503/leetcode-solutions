class Solution {
    public  void sortColors(int[] nums) {
        int zeros =0;
        int twos = nums.length-1;
        int mid =0;

        while(mid <= twos){
            int val = nums[mid];
            if(val == 0){
                int temp = nums[zeros];
                nums[zeros] = nums[mid];
                nums[mid] = temp;

                mid++;
                zeros++;
            }
            else if(val == 2){
                int temp = nums[twos];
                nums[twos] = nums[mid];
                nums[mid] = temp;

                twos--;
            }
            else{
                mid++;
            }
        }
    }
}
/**

    0 1 2 3 4 5
    0 0 1 1 2 2
        L R


    1  0  2
       L  R

*/