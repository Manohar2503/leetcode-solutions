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
    static int height;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root ==  null) return list;
        height = 0;
        dfs(root,1,list);
        return list;
    }

    static void dfs(TreeNode root, int h, List<Integer> list){
        if(root == null) return;
        if(height <h) {
            height = h;
            list.add(root.val);
        }
        dfs(root.right, h+1, list);
        dfs(root.left,h+1, list);
    }
}