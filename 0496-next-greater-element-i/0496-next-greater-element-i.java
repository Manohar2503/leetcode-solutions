class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int m = nums1.length;
        int[] result = new int[m];
        if(nums1.length==0) return result;

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();


        for(int i=n-1;i>=0;i--){
            int val = nums2[i];
            while(!st.isEmpty() && st.peek() < val) st.pop();
            if(st.isEmpty()) map.put(val, -1);
            else map.put(val, st.peek());
            st.push(val);
        }
        int j=0;
        for(int num : nums1){
            result[j++] = map.get(num);
        }

        return result;
    }
}