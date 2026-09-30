class Solution {
    public long minimumTime(int[] time, int totalTrips) {

        long minTime = Integer.MAX_VALUE;

        // Find the fastest bus
        for (int t : time) {
            minTime = Math.min(minTime, t);
        }

        long left = minTime;
        long right = minTime * (long) totalTrips;

        while (left < right) {

            long mid = left + (right - left) / 2;

            long trips = 0;

            for (int t : time) {
                trips += mid / t;

                // No need to calculate further
                if (trips >= totalTrips) {
                    break;
                }
            }

            if (trips >= totalTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}