class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i=nums2.length-1;i>=0;i--){
            int val = nums2[i];
            map.put(val, i);

            while(!stack.isEmpty() && stack.peek() < val) stack.pop();
            if(stack.isEmpty()) nums2[i] = -1;
            else nums2[i] = stack.peek();

            stack.push(val);
        }

        int[] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int index = map.get(nums1[i]);
            result[i] = nums2[index];
        }

        return result;
    }
}