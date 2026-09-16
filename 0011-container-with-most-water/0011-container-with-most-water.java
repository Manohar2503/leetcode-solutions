class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int left =0;
        int right = n-1;
        int result =0;

        while(left < right){
            int l = right - left;
            int h = Math.min(height[left], height[right]);
            result = Math.max(result, l * h); 
            if(height[left] < height[right]) left++;
            else right--;
        }
        return result;
    }
}