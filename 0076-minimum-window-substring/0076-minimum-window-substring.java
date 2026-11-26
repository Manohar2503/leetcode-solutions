
class Solution {
    public String minWindow(String s, String t) {

        int slen = s.length();
        int tlen = t.length();

        if(slen < tlen) return "";

        int[] freqs = new int[128];

        for(int i = 0; i < tlen; i++) {
            freqs[t.charAt(i)]++;
        }

        int left = 0;
        int count = 0;
        int min_Len = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0; right < slen; right++) {

            char ch = s.charAt(right);

            if(freqs[ch] > 0) {
                count++;
            }

            freqs[ch]--;

            while(count == tlen) {

                if(min_Len > right - left + 1) {
                    min_Len = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freqs[leftChar]++;
                if(freqs[leftChar] > 0) {
                    count--;
                }
                left++;
            }
        }

        if(min_Len == Integer.MAX_VALUE) return "";
        return s.substring(start, start + min_Len);
    }
}
