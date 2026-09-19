class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int maxValue = 0;

        for(int val: arr) maxValue = Math.max(maxValue, val);
        int index =0;
        int count =0;

        for(int i=1;i<=maxValue;i++){
            if(arr[index]==i){
                index++;
                continue;
            }
            count++;
            if(count == k) return i;
        }

        return maxValue+(k-count);
    }
}
