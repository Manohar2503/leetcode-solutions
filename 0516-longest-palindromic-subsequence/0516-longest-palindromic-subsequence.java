class Solution {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(s,0,s.length()-1);
    }
    private int dfs(String s,int i,int j){
        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=2+dfs(s,i+1,j-1);
        }
        return dp[i][j]=Math.max(dfs(s,i,j-1),dfs(s,i+1,j));
    }
}