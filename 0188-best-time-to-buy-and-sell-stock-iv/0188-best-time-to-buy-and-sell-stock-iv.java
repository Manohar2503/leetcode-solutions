
class Solution {
    int[][][] dp;

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        dp = new int[n][k + 1][2];

        for (int[][] day : dp) {
            for (int[] state : day) {
                Arrays.fill(state, -1);
            }
        }

        return solve(0, k, 0, prices);
    }

    private int solve(int i, int transactions,
                      int holding, int[] prices) {

        // No days remaining
        if (i == prices.length) {
            return holding == 1 ? Integer.MIN_VALUE / 2 : 0;
        }

        // No transactions remaining
        if (transactions == 0) {
            return holding == 1 ? Integer.MIN_VALUE / 2 : 0;
        }

        if (dp[i][transactions][holding] != -1) {
            return dp[i][transactions][holding];
        }

        int skip = solve(i + 1, transactions, holding, prices);

        int action;

        if (holding == 0) {
            // Buy
            action = -prices[i] +
                     solve(i + 1, transactions, 1, prices);
        } else {
            // Sell
            action = prices[i] +
                     solve(i + 1, transactions - 1, 0, prices);
        }

        return dp[i][transactions][holding] =
               Math.max(skip, action);
    }
}
