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
    static int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return build(0, inorder.length-1, preorder, inorder);
    }

    static TreeNode build(int left, int right, int[] preorder, int[] inorder){
        if(index >= preorder.length) return null;
        if(left > right) return null;
        TreeNode root = new TreeNode(preorder[index]);
        int mid = search(left, right, inorder, preorder[index]);
        index++;

        root.left =  build(left, mid-1, preorder, inorder);
        root.right =  build(mid+1, right, preorder, inorder);

        return root;
    }

    static int search(int left, int right, int[] inorder, int target){
        for(int i=left;i<=right;i++){
            if(inorder[i] == target) return i;
        }
        return -1;
    }
}
/*

    preorder -> Root left right 
    inorder  -> left root right

                       j
        pre - >    3 9 20 15 7
                     
                          i
        ino - >    9 3 15 20 7


*/