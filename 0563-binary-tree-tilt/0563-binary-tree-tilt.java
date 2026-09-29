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
    public int findTilt(TreeNode root) {
        result =0;
        finding_tilt_sum(root);
        return result;
    }

    static int finding_tilt_sum(TreeNode root){
        if(root == null) return 0;
        int left_sum = finding_tilt_sum(root.left);
        int right_sum = finding_tilt_sum(root.right);
        result += Math.abs(left_sum - right_sum);
        return left_sum + right_sum + root.val;
    }
}

 