
class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        Integer[][] dp = new Integer[n][n];

        return game(0, n - 1, prefix, dp);
    }

    static int game(int start, int end, int[] prefix,
                    Integer[][] dp) {

        if (start == end) return 0;

        if (dp[start][end] != null)
            return dp[start][end];

        int maxScore = 0;

        for (int x = start; x < end; x++) {

            int leftSum = prefix[x + 1] - prefix[start];
            int rightSum = prefix[end + 1] - prefix[x + 1];

            if (leftSum < rightSum) {

                maxScore = Math.max(maxScore,
                    leftSum + game(start, x, prefix, dp));

            } else if (leftSum > rightSum) {

                maxScore = Math.max(maxScore,
                    rightSum + game(x + 1, end, prefix, dp));

            } else {

                int left = leftSum + game(start, x, prefix, dp);
                int right = rightSum + game(x + 1, end, prefix, dp);

                maxScore = Math.max(maxScore, Math.max(left, right));
            }
        }

        return dp[start][end] = maxScore;
    }
}
