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
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root.left, root.right);
    }
    static boolean symmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left==null || right == null) return false;
        if(left.val != right.val) return false;

        return symmetric(left.right, right.left) && symmetric(left.left, right.right);
    }
}
/**

            1
        2   |    2
     3    4 |  4   3


 
 */