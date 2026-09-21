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
        if(preorder.length==0 || inorder.length==0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        index =0;
        return dfs(0, inorder.length-1, preorder, inorder, map);
    }

    static TreeNode dfs(int start, int end, int[] preorder, int[] inorder, Map<Integer, Integer> map){
        if(start > end) return null;
        int rootNode = preorder[index++];
        TreeNode root = new TreeNode(rootNode);
        root.left = dfs(start, map.get(rootNode)-1, preorder, inorder,map);
        root.right = dfs(map.get(rootNode)+1, end, preorder, inorder,map);
        return root;
    }
}