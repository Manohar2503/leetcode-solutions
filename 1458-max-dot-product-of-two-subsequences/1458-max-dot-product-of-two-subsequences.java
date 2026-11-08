
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int NEG = Integer.MIN_VALUE / 4;

        int[][] dp = new int[n + 1][m + 1];

        // Initialize impossible empty states
        for (int[] row : dp) {
            Arrays.fill(row, NEG);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                int product = nums1[i - 1] * nums2[j - 1];

                int start = product;

                int extend = product + dp[i - 1][j - 1];

                int skip1 = dp[i - 1][j];

                int skip2 = dp[i][j - 1];

                dp[i][j] = Math.max(
                    start,
                    Math.max(extend, Math.max(skip1, skip2))
                );
            }
        }

        return dp[n][m];
    }
}
