class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int max_result =0;
        if(n == 1) return 0;
        
        for(int i=0;i<n;i++){
            if(min > prices[i]) min = prices[i];
            else{
                max_result = Math.max(max_result, prices[i] - min);
            }
        }
        return max_result;
    }
}