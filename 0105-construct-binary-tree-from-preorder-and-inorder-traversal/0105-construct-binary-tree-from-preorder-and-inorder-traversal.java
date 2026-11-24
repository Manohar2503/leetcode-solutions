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
        int n = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(inorder[i], i);
        }

        index = 0;
        return build(0, n, preorder, inorder, map);
    }

    static TreeNode build(int start, int end, int[] preorder, int[] inorder, Map<Integer, Integer> map){
        if(start > end) return null;
        if(index >= preorder.length) return null;
        
        int nodeIndex = map.get(preorder[index]);
        TreeNode root = new TreeNode(preorder[index++]);
        
        root.left = build(start, nodeIndex-1, preorder, inorder, map);
        root.right = build(nodeIndex+1, end, preorder, inorder, map);

        return root;
    }
}
/**

    preorder - > Root left right
    inorder - > left Root right
           I
    pre -> 3 9 20 15 7
             M
    in ->  9 3 15 20 7
    
 
*/