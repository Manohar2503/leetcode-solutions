class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int max_length = 0;
        int left =0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                left = Math.max(left, map.get(ch)+1);
            }

            map.put(ch, i);
            max_length = Math.max(max_length, i - left+1);
        }

        return max_length;
    }
}
/**
              L
        b a a a b c a 
        0 1 2 3 4 5 6
                R

        b : 0
        a : 2

*/