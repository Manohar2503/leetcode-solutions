class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int[] trip : trips) {
            min = Math.min(min, trip[1]); // pickup location
            max = Math.max(max, trip[2]); // drop-off location
        }

        int[] result = new int[max + 1];

        for (int[] trip : trips) {
            int passengers = trip[0];
            int left = trip[1];
            int right = trip[2];

            result[left]  += passengers;
            result[right] -= passengers;
        }

        int currentPassengers = 0;

        for (int i = 0; i <= max; i++) {
            currentPassengers += result[i];
            if (currentPassengers > capacity) {
                return false;
            }
        }
        return true;
    }
}