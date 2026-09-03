class Solution {

    public long subArrayRanges(int[] nums) {
        return sumMax(nums) - sumMin(nums);
    }

    private long sumMin(int[] nums) {

        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous smaller or equal
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() &&
                   nums[st.peek()] > nums[i]) {
                st.pop();
            }

            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next smaller
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() &&
                   nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {

            long leftCount = i - left[i];
            long rightCount = right[i] - i;

            sum += (long) nums[i] *
                   leftCount *
                   rightCount;
        }

        return sum;
    }

    private long sumMax(int[] nums) {

        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous greater or equal
        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() &&
                   nums[st.peek()] < nums[i]) {
                st.pop();
            }

            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next greater
        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() &&
                   nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long sum = 0;

        for (int i = 0; i < n; i++) {

            long leftCount = i - left[i];
            long rightCount = right[i] - i;

            sum += (long) nums[i] *
                   leftCount *
                   rightCount;
        }

        return sum;
    }
}