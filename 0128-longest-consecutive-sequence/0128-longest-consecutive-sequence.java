class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        int max_len =0;

        for(int num: set){
            int len =1;
            if(!set.contains(num-1)){
                int val = num+1;
                while(set.contains(val)) {
                    len++;
                    val++;
                }
                max_len = Math.max(max_len, len);
            }
        }

        return max_len;
    }
}