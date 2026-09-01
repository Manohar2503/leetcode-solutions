class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] next = new int[20001];
        Arrays.fill(next, -1);

        Stack<Integer> st = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {

            int val = nums2[i];

            while (!st.isEmpty() && st.peek() < val) {
                st.pop();
            }

            if (!st.isEmpty()) {
                next[val + 10000] = st.peek();
            }

            st.push(val);
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = next[nums1[i] + 10000];
        }

        return result;
    }
}