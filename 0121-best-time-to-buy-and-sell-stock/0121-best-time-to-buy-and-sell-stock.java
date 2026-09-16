class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int result = 0;

        for(int price: prices){
            if(price < min){
                min = price;
                continue;
            }
            result = Math.max(result, price - min);
        }

        return result;
    }
}