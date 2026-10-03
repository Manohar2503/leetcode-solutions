class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int j = s.length()-1;
        while(j>=0 && s.charAt(j)!=' '){
            j--;
        }

        return s.length() - j -1;
    }
}
/**
    0 1 2 3 3 4 5 6 7 8 9 
    m a n o h a r   l o k

    len - 10 - 6

 */