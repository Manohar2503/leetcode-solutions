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
    static int postLen;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postLen = postorder.length-1;
        return constructTree(inorder, postorder, 0, inorder.length-1);
    }

    static TreeNode constructTree(int[] inorder, int[] postorder, int inLeft, int inRight){
        
        
        if(inLeft > inRight) return null;
        TreeNode root = new TreeNode(postorder[postLen--]);
        int start = findRoot(inorder, root.val, inLeft, inRight);
        root.right =  constructTree(inorder, postorder, start+1, inRight);
        root.left =  constructTree(inorder, postorder, inLeft, start-1);

        return root;
    }

    static int findRoot(int[] inorder, int root, int start, int end){
        for(int i=start;i<=end;i++){
            if(inorder[i] == root) return i;
        }
        return -1;
    }
}


/*
    Left Root Right            Left Right Root
                                            I
    inorder = [9,3,15,20,7],   postorder = [9,15,7,20,3]
               LR                                             




*/