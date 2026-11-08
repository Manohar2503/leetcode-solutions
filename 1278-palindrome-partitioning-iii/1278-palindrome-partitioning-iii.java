
class Solution {
    public int palindromePartition(String s, int k) {

        int n = s.length();

        // Step 1: Precompute palindrome conversion costs
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len <= n; l++) {

                int r = l + len - 1;

                cost[l][r] = (s.charAt(l) == s.charAt(r) ? 0 : 1);

                if (len > 2) {
                    cost[l][r] += cost[l + 1][r - 1];
                }
            }
        }

        // Step 2: Initialize DP
        int INF = 1000000;

        int[][] dp = new int[n + 1][k + 1];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        // Step 3: Partition DP
        for (int p = 1; p <= k; p++) {

            for (int i = p; i <= n; i++) {

                for (int j = p - 1; j < i; j++) {

                    dp[i][p] = Math.min(
                        dp[i][p],
                        dp[j][p - 1] + cost[j][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
