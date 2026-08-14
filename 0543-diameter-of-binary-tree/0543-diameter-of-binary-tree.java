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
    static int diameter; 
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        diameterofatree(root);
        return diameter;
    }

    static int diameterofatree(TreeNode root){
        if(root == null) return 0;
        int l = diameterofatree(root.left);
        int r = diameterofatree(root.right);

        diameter = Math.max(diameter, l + r);
        return 1 + Math.max(l,r);
    }
}