import java.util.*;

class Solution {
    static int MOD = 1_000_000_007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = group.length;

        Integer[][][] dp = new Integer[m][n + 1][minProfit + 1];

        return schemes(0, 0, n, minProfit, group, profit, dp);
    }

    static int schemes(int index, int members, int n,
                       int minProfit, int[] group,
                       int[] profit, Integer[][][] dp) {

        // All crimes have been considered
        if (index == group.length) {
            return minProfit == 0 ? 1 : 0;
        }

        if (dp[index][members][minProfit] != null) {
            return dp[index][members][minProfit];
        }

        // Don't take the current crime
        long notTake = schemes(
            index + 1, members, n, minProfit,
            group, profit, dp
        );

        // Take the current crime
        long take = 0;

        if (members + group[index] <= n) {

            int newMinProfit = Math.max(0, minProfit - profit[index]);

            take = schemes(
                index + 1,
                members + group[index],
                n,
                newMinProfit,
                group,
                profit,
                dp
            );
        }

        return dp[index][members][minProfit] =
            (int)((take + notTake) % MOD);
    }
}