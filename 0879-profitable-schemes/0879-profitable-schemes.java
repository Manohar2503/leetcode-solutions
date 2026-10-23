class Solution {
    static final int MOD = 1_000_000_007;

    public int profitableSchemes(int n, int minProfit,
                                 int[] group, int[] profit) {

        int len = group.length;

        int[][][] dp = new int[len][n + 1][minProfit + 1];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return schemes(0, 0, 0, n, minProfit, group, profit, dp);
    }

    private int schemes(int index, int members, int currProfit,
                        int n, int minProfit, int[] group,
                        int[] profit, int[][][] dp) {

        if (members > n) return 0;

        if (index == group.length) {
            return currProfit >= minProfit ? 1 : 0;
        }

        if (dp[index][members][currProfit] != -1) {
            return dp[index][members][currProfit];
        }

        int notTake = schemes(index + 1, members, currProfit,
                              n, minProfit, group, profit, dp);

        int take = 0;

        if (members + group[index] <= n) {
            int newProfit = Math.min(minProfit,
                                     currProfit + profit[index]);

            take = schemes(index + 1,
                           members + group[index],
                           newProfit, n, minProfit,
                           group, profit, dp);
        }

        return dp[index][members][currProfit] =
                (int) ((take + (long) notTake) % MOD);
    }
}