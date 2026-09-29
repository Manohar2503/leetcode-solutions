class Solution {
    int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftBalance = dfs(root.left);
        int rightBalance = dfs(root.right);

        moves += Math.abs(leftBalance);
        moves += Math.abs(rightBalance);

        return root.val + leftBalance + rightBalance - 1;
    }
}