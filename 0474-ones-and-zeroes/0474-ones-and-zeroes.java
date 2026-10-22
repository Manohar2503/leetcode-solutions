import java.util.Arrays;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] subsets = new int[len][2];

        for (int i = 0; i < len; i++) {
            int zeros = 0, ones = 0;

            for (char c : strs[i].toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }

            subsets[i] = new int[]{zeros, ones};
        }

        int[][][] dp = new int[len][m + 1][n + 1];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return subset(0, m, n, subsets, dp);
    }

    static int subset(int index, int m, int n,
                      int[][] subsets, int[][][] dp) {

        if (index == subsets.length) return 0;

        if (dp[index][m][n] != -1) {
            return dp[index][m][n];
        }

        int zero = subsets[index][0];
        int one = subsets[index][1];

        // Not take
        int notTake = subset(index + 1, m, n, subsets, dp);

        // Take
        int take = 0;
        if (zero <= m && one <= n) {
            take = 1 + subset(
                index + 1, m - zero, n - one, subsets, dp
            );
        }

        return dp[index][m][n] = Math.max(take, notTake);
    }
}