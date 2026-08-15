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
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder,0,inorder.length-1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int instart, int inEnd){
        if(instart > inEnd) return null;

        int preval = preorder[preIndex++];
        TreeNode parent = new TreeNode(preval);
        int i=instart;
        int mid=0;
        while(i<=inEnd){
            if(inorder[i]==preval){
                mid = i;
                break;
            }
            i++;
        }

        parent.left = helper(preorder,inorder,instart,mid-1);
        parent.right = helper(preorder,inorder,mid+1,inEnd);
        return parent;
    }
}