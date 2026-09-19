class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] news = s.toCharArray();
        char[] newt = t.toCharArray();
        Arrays.sort(news);
        Arrays.sort(newt);
        if(Arrays.equals(news, newt)) return true;
        return false;
    }
}