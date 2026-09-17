import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length(), m = p.length();

        if (m > n) return ans;

        int[] freqP = new int[26];
        int[] freqW = new int[26];

        // Build frequency for p and first window of s
        for (int i = 0; i < m; i++) {
            freqP[p.charAt(i) - 'a']++;
            freqW[s.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(freqP, freqW)) ans.add(0);

        // Slide the window
        for (int i = m; i < n; i++) {
            // add new char
            freqW[s.charAt(i) - 'a']++;

            // remove old char
            freqW[s.charAt(i - m) - 'a']--;

            // check anagram
            if (Arrays.equals(freqP, freqW)) {
                ans.add(i - m + 1);
            }
        }

        return ans;
    }
}