/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        int leftMax = maxPathSum(root.left);
        int rightMax = maxPathSum(root.right);
        if(root.val > 0 && leftMax!=Integer.MIN_VALUE && rightMax!=Integer.MIN_VALUE) {
            return root.val + leftMax + rightMax;
        }
        int max_val = Math.max(leftMax, rightMax);
        if(max_val == Integer.MIN_VALUE) return root.val;
        if(root.val > 0 && max_val > 0) return root.val + max_val;
        return Math.max(max_val , root.val);
    }
}