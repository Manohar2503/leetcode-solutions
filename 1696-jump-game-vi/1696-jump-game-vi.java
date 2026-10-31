class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;

        int[] dp = new int[n];
        Deque<Integer> qu = new ArrayDeque<>();

        dp[0] = nums[0];
        qu.offerLast(0);

        for(int i = 1; i < n; i++) {

            // Remove expired indices
            while(!qu.isEmpty() && qu.peekFirst() < i-k) {
                qu.pollFirst();
            }

            // Calculate maximum score
            dp[i] = nums[i] + dp[qu.peekFirst()];

            // Maintain decreasing DP values
            while(!qu.isEmpty() && dp[qu.peekLast()] <= dp[i]) {
                qu.pollLast();
            }

            qu.offerLast(i);
        }

        return dp[n-1];
    }
}