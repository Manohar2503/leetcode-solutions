class Solution {
    public int maxArea(int[] height) {
        int max = 0, area = 0;
        int i = 0, j = height.length-1;
        while (i != j) {
            if (height[i] < height[j]) {
                int min = height[i];
                area = (j-i) * min;
                i ++;
            } else {
                int min = height[j];
                area = (j-i) * min;
                j --;
            }
            if (area > max) {
                max = area;
            }
        }
        // area: (右-左) * min(左, 右)
        return max;
    }
}