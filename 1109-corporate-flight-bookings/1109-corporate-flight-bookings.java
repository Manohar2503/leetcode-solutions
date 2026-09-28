class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int len = bookings.length;
        int[] diff = new int[n+2];
        for(int[] booking: bookings){
            int left = booking[0];
            int right = booking[1];
            int val = booking[2];

            diff[left] += val;
            diff[right+1] -= val;
        } 

        int[] result = new int[n];
        int sum =0;
        for(int i=1;i<=n;i++){
            sum += diff[i];
            result[i-1] = sum;
        }

        return result;
    }
}
/*




*/