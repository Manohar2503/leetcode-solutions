class Solution {

    public int stoneGameVII(int[] piles) {
         int n = piles.length;

        Integer[][][] dp = new Integer[n][n][2];
        int[] prefix = new int[n+1];

        for(int i=0;i<n;i++){
            prefix[i+1] = prefix[i] + piles[i];
        }

        return minmax(0, n - 1, 0, piles, prefix, dp);
    }
    static int minmax(int i, int j, int player, int[] nums, int[] prefix, Integer[][][] dp) {

        if (i >= j) {
            return 0;
        }

        if (dp[i][j][player] != null) {
            return dp[i][j][player];
        }

        int np = 1 - player;
        int left = prefix[j+1] - prefix[i+1] - minmax(i + 1, j, np, nums, prefix, dp);
        int right = prefix[j] - prefix[i] - minmax(i, j - 1, np, nums, prefix, dp);
        return dp[i][j][player] = Math.max(left, right);
    }
}
