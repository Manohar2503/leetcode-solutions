class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;

        int prev2 = 1; // dp[i-2]
        int prev1 = 1; // dp[i-1]

        for (int i = 1; i < n; i++) {
            int curr = 0;
            char c = s.charAt(i);
            char p = s.charAt(i - 1);

            if (c != '0') {
                curr += prev1;
            }
            int two = (p - '0') * 10 + (c - '0');
            if (two >= 10 && two <= 26) {
                curr += prev2;
            }
            if (curr == 0) return 0;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}