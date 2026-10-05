class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen ==0 && tLen ==0) return true;
        if(sLen!=0 && tLen ==0) return false;
        if(sLen ==0) return true;
        int count =0;
        int left =0;

        for(int right =0; right< tLen; right++){
            char sChar = s.charAt(left);
            char tChar = t.charAt(right);
            if(sChar == tChar) {
                count++;
                left++;
            }
            if(count==sLen) return true;
        }

        return (count==sLen);
    }
}