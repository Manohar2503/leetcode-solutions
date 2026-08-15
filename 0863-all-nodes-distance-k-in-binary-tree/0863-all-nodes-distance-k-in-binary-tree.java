/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        findParents(root, map);
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        dfs(0, target, k, result,map,set);
        return result;
    }
    static void dfs(int count, TreeNode node, int k, List<Integer> result, Map<TreeNode, TreeNode> map, Set<TreeNode> set){
        if(node == null) return;
        if(set.contains(node)) return;
        set.add(node);
        if(count == k) {
            result.add(node.val);
            return;
        }
        
        dfs(count+1, node.left, k, result,map,set);
        dfs(count+1, node.right, k, result,map,set);
        dfs(count+1, map.get(node), k, result,map,set);
    }
    static void findParents(TreeNode root, Map<TreeNode, TreeNode> map){
        if(root == null) return;
        if(root.left!=null){
            map.put(root.left, root);
            findParents(root.left, map);
        }
        if(root.right!=null){
            map.put(root.right, root);
            findParents(root.right, map);
        }
    }
}