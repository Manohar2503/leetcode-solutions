/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p || root ==q){
            return root;
        }
        TreeNode leftnode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightnode = lowestCommonAncestor(root.right,p,q);
        if(leftnode!=null && rightnode!=null) return root;
        return (leftnode!=null)?leftnode:rightnode;
    }
}