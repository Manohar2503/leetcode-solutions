

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return recurse(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    public TreeNode recurse(int[] in, int a, int b, int[] post, int x, int y){
        if(a>b || x>y) return null;
        TreeNode root = new TreeNode(post[y]);
        int i=b;
        for(i=b;i>=a;i--){
            if(post[y] == in[i]){
                break;
            }
        }
        int numsRight = b-i;
        root.right = recurse(in, i+1, b, post, y-numsRight,y-1);
        root.left = recurse(in, a, i-1, post, x,y - numsRight -1);
        return root;
    }
}