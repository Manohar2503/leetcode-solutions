class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, arr, d, dp));
        }

        return ans;
    }

    private int dfs(int index, int[] arr, int d, int[] dp) {

        if (dp[index] != 0) {
            return dp[index];
        }

        int max = 1;

        // Right direction
        for (int i = index + 1; i <= index + d && i < arr.length; i++) {
            if (arr[i] >= arr[index]) break;

            max = Math.max(max, 1 + dfs(i, arr, d, dp));
        }

        // Left direction
        for (int i = index - 1; i >= index - d && i >= 0; i--) {
            if (arr[i] >= arr[index]) break;

            max = Math.max(max, 1 + dfs(i, arr, d, dp));
        }

        return dp[index] = max;
    }
}