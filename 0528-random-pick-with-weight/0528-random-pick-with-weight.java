class Solution {
    private int[] prefixSum;
    private int total;
    private Random random;
    public Solution(int[] w) {
        prefixSum = new int[w.length];
        random = new Random();
        prefixSum[0]=w[0];
        for(int i= 1;i<w.length;i++){
            prefixSum[i] = prefixSum[i-1]+w[i];
        }
        total = prefixSum[w.length-1];
    }
    
    public int pickIndex() {
        int num = random.nextInt(total) + 1;
        return binary(num);
    }

    public int binary(int num){
        int left = 0;
        int  right = prefixSum.length-1;
        int result =0;
        while(left <= right){
            int mid = left +(right - left)/2;
            
            if(prefixSum[mid] >= num){
                result = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */