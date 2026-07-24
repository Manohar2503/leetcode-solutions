class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
         String lcs = lcs(str1, str2);

        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : lcs.toCharArray()) {

            // add chars from str1 until LCS char
            while (i < str1.length() && str1.charAt(i) != c) {
                sb.append(str1.charAt(i));
                i++;
            }

            // add chars from str2 until LCS char
            while (j < str2.length() && str2.charAt(j) != c) {
                sb.append(str2.charAt(j));
                j++;
            }

            // add LCS character once
            sb.append(c);
            i++;
            j++;
        }

        // add remaining characters
        sb.append(str1.substring(i));
        sb.append(str2.substring(j));

        return sb.toString();
    }


   static String lcs(String str1, String str2) {
    int n = str1.length();
    int m = str2.length();

    int[][] dp = new int[n + 1][m + 1];

    // Build DP table
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                dp[i][j] = 1 + dp[i - 1][j - 1];
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }

    // Backtrack to get LCS string
    StringBuilder sb = new StringBuilder();
    int i = n, j = m;

    while (i > 0 && j > 0) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            sb.append(str1.charAt(i - 1));
            i--;
            j--;
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            i--;
        } else {
            j--;
        }
    }

    return sb.reverse().toString();
}

}