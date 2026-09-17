class Solution {
    /*
    max = 3 , count = 3
    a b c i i i d e  k=3 
          L     R 
    */
    public int maxVowels(String s, int k) {
        int n = s.length();
        int left =0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int count =0;
       
        for(int i=0;i<k;i++){
            if(set.contains(s.charAt(i))) count++;
        }
         int result =count;
        int right =k;

        while(right < n){
            if(set.contains(s.charAt(left))) count--;
            left++;
            if(set.contains(s.charAt(right))) count++;
            right++;
            result = Math.max(result , count);
            if(result==k) return k;
        }
        return result;
    }
}