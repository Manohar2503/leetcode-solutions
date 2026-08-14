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
    private int depth;
    public int maxDepth(TreeNode root) {
        depth =0;
        depth(root,1);
        return depth;
    }

    private void depth(TreeNode root, int len){
        if(root == null) return;
        depth = Math.max(depth, len);
        depth(root.left, len+1);
        depth(root.right, len+1);
    }
}