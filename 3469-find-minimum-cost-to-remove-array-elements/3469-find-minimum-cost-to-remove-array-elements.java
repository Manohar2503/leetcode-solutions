
import java.util.Arrays;

class Solution {
    int[][] memo;
    int[] nums;
    int n;

    public int minCost(int[] nums) {
        this.nums = nums;
        this.n = nums.length;

        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // First operation: choose 2 elements from the first 3.
        int ans = Integer.MAX_VALUE;

        // Keep nums[0], remove nums[1] and nums[2].
        ans = Math.min(ans,
            Math.max(nums[1], nums[2]) + solve(3, 0));

        // Keep nums[1], remove nums[0] and nums[2].
        ans = Math.min(ans,
            Math.max(nums[0], nums[2]) + solve(3, 1));

        // Keep nums[2], remove nums[0] and nums[1].
        ans = Math.min(ans,
            Math.max(nums[0], nums[1]) + solve(3, 2));

        return ans;
    }

    // i = next unprocessed index
    // j = index of the surviving element
    private int solve(int i, int j) {
        // Only the surviving element remains.
        if (i >= n) {
            return nums[j];
        }

        // Only two elements remain.
        if (i == n - 1) {
            return Math.max(nums[j], nums[i]);
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int a = nums[j];
        int b = nums[i];
        int c = nums[i + 1];

        // Remove a and b; c survives.
        int cost1 = Math.max(a, b) + solve(i + 2, i + 1);

        // Remove a and c; b survives.
        int cost2 = Math.max(a, c) + solve(i + 2, i);

        // Remove b and c; a survives.
        int cost3 = Math.max(b, c) + solve(i + 2, j);

        return memo[i][j] = Math.min(cost1,
                              Math.min(cost2, cost3));
    }
}
