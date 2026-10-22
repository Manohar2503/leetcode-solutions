
import java.util.Arrays;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for (int stone : stones) {
            totalSum += stone;
        }

        int target = totalSum / 2;
        int n = stones.length;

        int[][] dp = new int[n][target + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int subsetVal = subset(0, target, stones, dp);

        return totalSum - 2 * subsetVal;
    }

    int subset(int index, int remaining, int[] stones, int[][] dp) {
        if (index == stones.length || remaining == 0) {
            return 0;
        }

        if (dp[index][remaining] != -1) {
            return dp[index][remaining];
        }

        // Not take
        int notTake = subset(index + 1, remaining, stones, dp);

        // Take
        int take = 0;
        if (stones[index] <= remaining) {
            take = stones[index]
                 + subset(index + 1, remaining - stones[index], stones, dp);
        }

        return dp[index][remaining] = Math.max(take, notTake);
    }
}
