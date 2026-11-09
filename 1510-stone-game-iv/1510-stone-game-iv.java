
class Solution {
    public boolean winnerSquareGame(int n) {
        Boolean[] dp = new Boolean[n + 1];
        return game(n, dp);
    }

    static boolean game(int n, Boolean[] dp) {

        if (n == 0) return false;

        if (dp[n] != null) return dp[n];

        for (int x = 1; x * x <= n; x++) {

            if (!game(n - x * x, dp)) {
                return dp[n] = true;
            }
        }

        return dp[n] = false;
    }
}
