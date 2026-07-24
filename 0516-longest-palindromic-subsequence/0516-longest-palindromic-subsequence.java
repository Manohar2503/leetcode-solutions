class Solution {
    public int longestPalindromeSubseq(String s) {
        String r = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s,r);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int t1 = text1.length();
        int[][] dp = new int[t1+1][t1+1];
        for(int i=1;i<=t1;i++){
            for(int j=1;j<=t1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[t1][t1];
    }
}