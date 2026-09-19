class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //min capacity: max weight
        //max capacity: total weight

        //Binary search on capacities between min and max;

        int max_weight = 0;
        int total_weight = 0;
        for(int weight: weights){
            max_weight = Math.max(weight, max_weight);
            total_weight += weight;
        }

        int left = max_weight;
        int right = total_weight;

        while(left < right){
            int capacity = left + (right - left)/2;

            int daysNeeded = 0;
            int currWeight = 0;

            for(int weight: weights){
                if(currWeight + weight > capacity){
                    daysNeeded++;
                    currWeight = 0;
                }
                currWeight += weight;
            }

            if(daysNeeded < days){ //this capacity works checks smaller as well
                right = capacity;
            }
            else{ // it doesnt work for this capacity
                left = capacity + 1;
            }
        }

        return left;
    }
}