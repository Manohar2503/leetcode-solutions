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
    
    public int maxDepth(TreeNode root) {
        return levelorder(root);
        
    }
    static int levelorder(TreeNode root){
        if(root == null) return 0;

        int l = levelorder(root.left);
        int r = levelorder(root.right);

        return 1 + Math.max(l,r);
    }
}