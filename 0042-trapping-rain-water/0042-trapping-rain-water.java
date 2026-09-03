class Solution {
    public int trap(int[] height) {

        Deque<Integer> stack = new ArrayDeque<>();

        int water = 0;

        for (int i = 0; i < height.length; i++) {

            while (!stack.isEmpty() &&
                   height[i] > height[stack.peek()]) {

                int bottom = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();

                int width = i - left - 1;

                int waterHeight =
                    Math.min(height[left], height[i])
                    - height[bottom];

                water += width * waterHeight;
            }

            stack.push(i);
        }

        return water;
    }
}