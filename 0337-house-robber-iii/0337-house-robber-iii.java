class Solution {
    public int rob(TreeNode root) {
        int[] result = solve(root);
        return Math.max(result[0], result[1]);
    }

    private int[] solve(TreeNode root) {
        // No house
        if (root == null) {
            return new int[]{0, 0};
        }

        // Get results from left and right subtrees
        int[] left = solve(root.left);
        int[] right = solve(root.right);

        // If we rob this node, we cannot rob its children
        int takeNode = root.val + left[1] + right[1];

        // If we don't rob this node, children can be either robbed or not
        int notTakeNode = Math.max(left[0], left[1])
                        + Math.max(right[0], right[1]);

        return new int[]{takeNode, notTakeNode};
    }
}