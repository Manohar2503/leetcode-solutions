class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        boolean[] dp = new boolean[n];
        dp[0] = true;

        int reachableCount = 0;

        for (int i = 1; i < n; i++) {

            // Add the index entering the valid jump window
            int add = i - minJump;
            if (add >= 0 && dp[add]) {
                reachableCount++;
            }

            // Remove the index leaving the valid jump window
            int remove = i - maxJump - 1;
            if (remove >= 0 && dp[remove]) {
                reachableCount--;
            }

            // A zero is reachable if at least one valid
            // previous position is reachable
            if (s.charAt(i) == '0' && reachableCount > 0) {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}