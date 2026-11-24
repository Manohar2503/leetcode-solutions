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
    static TreeNode prev;
    public void flatten(TreeNode root) {
        prev = null;
        flattenTree(root);
    }
    static void flattenTree(TreeNode root){
        if(root == null) return;
         flattenTree(root.right);
         flattenTree(root.left);
         root.right = prev;
         prev = root;
         root.left = null;
    }
}