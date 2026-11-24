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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int[] res = {0};
        number(0, root, res);
        return res[0];
    }

    static void number(int num, TreeNode root, int[] res){
        if(root.left == null && root.right == null){
            res[0] += num*10 + root.val;
            return;
        }

        if(root.left!=null) number(num * 10 + root.val, root.left, res);
        if(root.right!=null) number(num * 10 + root.val, root.right, res);
    }
}