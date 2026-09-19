class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int left =0;
        int right =0;
        for(int weight: weights){
            left = Math.max(left, weight);
            right += weight;
        }

        while(left < right){
            int mid = left + (right - left)/2;
            int newDays = 0;

            int j=0;
            while(j< n){
                int count =0;
                newDays++;
                while(j < n && count + weights[j] <= mid) {
                    count += weights[j];
                    j++;
                }
            }

            if(newDays <= days){
                right = mid;
            }
            else left = mid+1;
        }

        return left;
    }
}
/*


    1 2 3 4 5 6 7 8 9 10  

    min = 15 
    max = 15
    mid = 14

    ans = 15
*/