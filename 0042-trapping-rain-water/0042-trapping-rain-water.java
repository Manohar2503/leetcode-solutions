class Solution {
    /*
    water - 6 
                  lr   
    0 1 0 2 1 0 1 3 2 1 2 1

leftmax- 3 
rightmax-2
    */
    public int trap(int[] height) {
        int left =0;
        int right = height.length-1;
        int result =0;
        int leftmax =0;
        int rightmax =0;
        while(left < right){
            if(height[left] <= height[right]){
                if(leftmax > height[left]){
                    result += leftmax - height[left];
                }
                else{
                    leftmax = height[left];
                }
                left++;
            }
            else{
                if(rightmax > height[right]){
                    result += rightmax - height[right];
                }
                else{
                    rightmax = height[right];
                }
                right--;
            }
        }
        return result;
    }
}