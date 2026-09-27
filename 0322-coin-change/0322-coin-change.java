class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount ==0) return 0;
        if(n == 0) return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] =0;
        for(int coin: coins){
            for(int i=coin;i<= amount;i++){
                dp[i] = Math.min(dp[i], dp[i-coin] +1);
            }
        }

        return (dp[amount] > amount)?-1:dp[amount];
    }
}

/*


    coins = 1 2 5    amount = 11

    amount = 1   min_possible = 1

    amount = 2  
    - > noof ways = 1 + 1, 2  
    - > min_possible = 1


*/