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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return path(root, 0L, targetSum, map);
    }

    static int path(TreeNode root, long currentSum, int target,  Map<Long, Integer> map){
        if(root == null) return 0;
        currentSum += root.val;
        int count = map.getOrDefault(currentSum - target, 0);
        map.put(currentSum, map.getOrDefault(currentSum, 0)+1);

        count += path(root.left, currentSum, target, map);
        count += path(root.right, currentSum, target, map);

        map.put(currentSum, map.get(currentSum)-1);
        return count;
    }
}