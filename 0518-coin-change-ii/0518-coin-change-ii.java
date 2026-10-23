class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        
        for(int coin: coins){
            for(int sum = coin; sum<=amount; sum++){
                dp[sum] = dp[sum] + dp[sum - coin];
            }
        }

        return dp[amount];
    }
}
/**
    0 1 2
    1 2 5  amount = 5
    
     0 1 2 3 4 5
    [1 1 2 2 3 4]


*/