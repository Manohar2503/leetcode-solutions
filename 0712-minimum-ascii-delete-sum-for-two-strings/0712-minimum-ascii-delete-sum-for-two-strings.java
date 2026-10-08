class Solution {
    public int minimumDeleteSum(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        // dp[i][j] = minimum ASCII deletion sum
        // to make s1[i...] and s2[j...] equal
        int[][] dp = new int[n + 1][m + 1];

        // s1 is exhausted -> delete remaining characters of s2
        for (int j = m - 1; j >= 0; j--) {
            dp[n][j] = s2.charAt(j) + dp[n][j + 1];
        }

        // s2 is exhausted -> delete remaining characters of s1
        for (int i = n - 1; i >= 0; i--) {
            dp[i][m] = s1.charAt(i) + dp[i + 1][m];
        }

        // Fill DP bottom-up
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                char char1 = s1.charAt(i);
                char char2 = s2.charAt(j);

                // Same character -> keep both
                if (char1 == char2) {
                    dp[i][j] = dp[i + 1][j + 1];
                }

                // Different characters -> delete one of them
                else {
                    int deleteFromS1 = char1 + dp[i + 1][j];
                    int deleteFromS2 = char2 + dp[i][j + 1];

                    dp[i][j] = Math.min(deleteFromS1, deleteFromS2);
                }
            }
        }

        return dp[0][0];
    }
}