class Solution {
    public int maxValue(int[][] events, int k) {

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int n = events.length;

        int[][] dp = new int[n + 1][k + 1];

        for (int i = n - 1; i >= 0; i--) {

            int next = binarySearch(events, events[i][1]);

            for (int j = 1; j <= k; j++) {

                int skip = dp[i + 1][j];

                int take = events[i][2] + dp[next][j - 1];

                dp[i][j] = Math.max(take, skip);
            }
        }

        return dp[0][k];
    }

    private int binarySearch(int[][] events, int target) {

        int left = 0;
        int right = events.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (events[mid][0] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}