
class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return matches(0, 0, s, p, dp);
    }

    static boolean matches(int i, int j, String s, String p, Boolean[][] dp){
        int sl = s.length();
        int pl = p.length();

        if (j == pl) {
            return i == sl;
        }

        if(dp[i][j]!=null) return dp[i][j];

        char pc = p.charAt(j);

        if (pc == '*') {
            return dp[i][j] = matches(i, j + 1, s, p, dp)
                || (i < sl && matches(i + 1, j, s, p, dp));
        }

        if (i == sl) {
            return false;
        }

        char sc = s.charAt(i);
        boolean isEqual = (sc == pc || pc == '?');

        return dp[i][j] = isEqual && matches(i + 1, j + 1, s, p, dp);
    }
}
