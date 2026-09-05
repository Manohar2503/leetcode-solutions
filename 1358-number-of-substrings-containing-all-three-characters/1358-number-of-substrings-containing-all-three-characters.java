class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left =0;
        Map<Character, Integer> map = new HashMap<>();
        int result =0;

        for(int right =0;right<n;right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            
            while(map.size() ==3){
                result += n - right;
                char c = s.charAt(left);
                left++;
                map.put(c, map.get(c)-1);
                if(map.get(c)==0) map.remove(c);
            }
        }

        return result;
    }
}
/*
        L
        a b c a b c
              R
        n = 6 
        n - right = 6 - 2 = 4
map - {
        a : 0
        b : 1
        c : 2
    }
    
     map size = 3

*/