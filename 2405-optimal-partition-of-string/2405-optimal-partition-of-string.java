class Solution {
    public int partitionString(String s) {
        if(s.length()==0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int result = 1;
        int left =0;
        int right =0;
        for(right =0;right < s.length();right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                result++;
               // int idx = map.get(ch);
                while(left < right){
                map.remove(s.charAt(left));
                    left++;
                }
            }
            map.put(ch, right);
        }
        return result;
    }
}