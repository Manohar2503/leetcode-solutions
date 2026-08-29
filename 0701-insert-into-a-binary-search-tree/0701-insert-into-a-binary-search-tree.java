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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode node = new TreeNode(-1);
       insert(root,node,val);
       return root;
    }
    static void insert(TreeNode root, TreeNode prev, int val){
        if(root == null) {
            if(prev.val<val) {
                TreeNode node = new TreeNode(val);
                prev.right = node;
            }
            else{
                TreeNode node = new TreeNode(val);
                prev.left = node;
            }
            return;
        }
        
        if(root.val<val) insert(root.right,root,val);
        else  insert(root.left,root,val);
    }
}