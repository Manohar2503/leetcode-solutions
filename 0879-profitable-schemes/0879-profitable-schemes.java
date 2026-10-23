
class Solution {
    static final int MOD = 1_000_000_007;

    public int profitableSchemes(int n, int minProfit,
                                 int[] group, int[] profit) {

        int[][] dp = new int[n + 1][minProfit + 1];

        dp[0][0] = 1;

        for (int i = 0; i < group.length; i++) {
            int members = group[i];
            int earn = profit[i];

            for (int j = n; j >= members; j--) {
                for (int p = minProfit; p >= 0; p--) {

                    int newProfit = Math.min(minProfit, p + earn);

                    dp[j][newProfit] =
                        (dp[j][newProfit] + dp[j - members][p]) % MOD;
                }
            }
        }

        int ans = 0;

        for (int j = 0; j <= n; j++) {
            ans = (ans + dp[j][minProfit]) % MOD;
        }

        return ans;
    }
}
