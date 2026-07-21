class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if(n==0 || n==1) return n;
        
        int left =0;
        int right =0;
        int r = left;
        for(right =1;right<n;right++){
            if(chars[left] == chars[right]) continue;
            if(right - left > 1){
                chars[r++] = chars[left];
                String str = (right - left) + "";
                for(char ch: str.toCharArray()) chars[r++] = ch;
            }
            else {
                chars[r++] = chars[left];
            }
            left = right;
        }
            if(right - left > 1){
                chars[r++] = chars[left];
                String str = (right - left) + "";
                for(char ch: str.toCharArray()) chars[r++] = ch;
            }
            else {
                chars[r++]  = chars[left];
            }
            return r;
    }
}