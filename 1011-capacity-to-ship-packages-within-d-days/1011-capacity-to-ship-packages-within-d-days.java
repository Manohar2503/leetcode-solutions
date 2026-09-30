class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = 0;
        int total =0;
        for(int val:weights) {
            max = Math.max(max, val);
            total += val;
        }
        int result =0;
        int left = max;
        int right = total;
        while(left <= right){
            int mid = left + (right - left)/2;
            int k =0;
            int j=0;
            while(j < n){
                int sum =0;
                while(j< n && sum+weights[j] <= mid){
                    sum += weights[j];
                    j++;
                }
                k++;
            }

            if(k <= days){
                right = mid-1;
                result = mid;
            }
            else left  = mid+1;
        }

        return result;
    }
}