class Solution {

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        int[] suffix = new int[n + 1];

        // Calculate suffix sums
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        Integer[][] dp = new Integer[n][n + 1];

        return solve(0, 1, piles, suffix, dp);
    }

    static int solve(int i, int M, int[] piles,
                     int[] suffix, Integer[][] dp) {

        int n = piles.length;

        // No piles remaining
        if (i >= n) {
            return 0;
        }

        // Current player can take all remaining piles
        if (2 * M >= n - i) {
            return suffix[i];
        }

        if (dp[i][M] != null) {
            return dp[i][M];
        }

        int maxScore = 0;

        for (int X = 1; X <= 2 * M; X++) {

            int opponent = solve(
                i + X,
                Math.max(M, X),
                piles,
                suffix,
                dp
            );

            int current = suffix[i] - opponent;

            maxScore = Math.max(maxScore, current);
        }

        return dp[i][M] = maxScore;
    }
}