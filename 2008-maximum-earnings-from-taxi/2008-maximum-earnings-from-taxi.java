class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {

        Arrays.sort(rides, (a, b) -> a[0] - b[0]);

        int m = rides.length;

        long[] dp = new long[m + 1];

        for (int i = m - 1; i >= 0; i--) {

            int next = binarySearch(rides, rides[i][1]);

            long notTake = dp[i + 1];

            long take = rides[i][1] - rides[i][0]
                      + rides[i][2] + dp[next];

            dp[i] = Math.max(notTake, take);
        }

        return dp[0];
    }

    static int binarySearch(int[][] rides, int target) {

        int left = 0;
        int right = rides.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (rides[mid][0] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}