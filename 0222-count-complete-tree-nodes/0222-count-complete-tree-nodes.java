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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = 0;
        TreeNode node = root;
        while(node.left !=null) {
            leftHeight++;
            node = node.left;
        }

        node = root;
        int rightHeight=0;
        while(node.right!=null){
            rightHeight++;
            node = node.right;
        }

        if(leftHeight == rightHeight) return (int)Math.pow(2, rightHeight+1)-1;
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);

        return 1 + leftNodes + rightNodes;
    }
}