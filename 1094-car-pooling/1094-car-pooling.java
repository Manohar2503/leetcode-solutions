class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int maxIndex = 0;

        for(int[] trip: trips){
            int right = trip[2];
            if(maxIndex < right) maxIndex = right;
        }

        int[] diffArray = new int[maxIndex+2];
        for(int[] trip: trips){
            int val = trip[0];
            int left = trip[1];
            int right = trip[2];
            
            diffArray[left] += val;
            diffArray[right] -= val;
        }

        int sum =0;
        for(int i=0;i<=maxIndex;i++){
            sum += diffArray[i];
            if(sum>capacity) return false;
        }

        return true;
    }
}
/*
    capacity - > 4

    2  1  5 
    3  3  7 

    1 2 3 4 5 6 7 8
    0 0 0 0 0 0 0 0
    2       3-2  -3
    2 2 2 2 5
pre:2 2 5 5 5 3 3 0

*/