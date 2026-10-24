class Solution {
    public int numSquares(int n) {
        int squares = (int) Math.sqrt(n);

        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] =0;

        for(int i=1;i<=squares;i++){
            int square = i * i;
            for(int j = square; j<=n;j++){
                dp[j] = Math.min(dp[j], dp[j - square]+1);
            }
        }
        return dp[n];
     }
}


/**
        n = 12
        sq = 3


         0  1  2  3  4  5  6  7  8  9  10  11  12 
         0  1  2  3  1  2  3  4  2  1   2  3    3     


*/