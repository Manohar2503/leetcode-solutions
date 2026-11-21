class Solution {
    public int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int max_Area = 0;

        while(left < right){
            int leftValue = height[left];
            int rightValue = height[right];

            int width = right - left;
            if(leftValue <= rightValue){
                max_Area = Math.max(max_Area, leftValue * width);
                left++;
            }
            else{
                max_Area = Math.max(max_Area, rightValue * width);
                right--;
            }
        }

        return max_Area;
    }
}