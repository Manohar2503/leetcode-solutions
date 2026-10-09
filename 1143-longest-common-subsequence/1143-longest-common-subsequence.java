
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
      
        if (text2.length() > text1.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int n = text1.length();
        int m = text2.length();

        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int prev = 0; // Previous row's diagonal value

            for (int j = 1; j <= m; j++) {
                int temp = dp[j]; // Save the old value (above)

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                prev = temp;
            }
        }

        return dp[m];
    }
}
