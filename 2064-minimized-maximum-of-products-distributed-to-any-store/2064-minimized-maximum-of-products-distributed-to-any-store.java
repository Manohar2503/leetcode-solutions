class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        int left =1;
        int total =0;
        for(int num: quantities) total = Math.max(total, num);

        int right = total;
        int result = 0;

        while(left < right){
            int mid = left + (right - left)/2;

            int count = 0;
            for(int quantity : quantities){
                count += (quantity + mid -1)/ mid;
            }

            if(count <= n){
                right = mid;
            }
            else left = mid +1;
        }

        return left;
    }
}