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
    static int result;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        result =0;
        sumOfRootTOLeaf(0, root);
        return result;
    }
    static void sumOfRootTOLeaf(int sum, TreeNode node){
        if(node == null) return;
        if(node.left == null && node.right == null){
            result += sum * 10 + node.val;
            return;
        }
        sum = sum * 10 + node.val;
        sumOfRootTOLeaf(sum, node.left);
        sumOfRootTOLeaf(sum, node.right);
    }
}