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
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        return find(root, k, map);
    }

    static boolean find(TreeNode root, int k, Map<Integer, Integer> map){
        if(root == null) return false;
        if(map.containsKey(k - root.val)) return true;
        map.put(root.val, root.val);
        return find(root.left, k, map) || find(root.right, k, map);
    }
}