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
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentNodes(null, root, parentMap);

        List<Integer> list = new ArrayList<>();
        Set<TreeNode> visitedSet = new HashSet<>();

        kdistanceNodes(k, target, parentMap, list, visitedSet);
        return list;
    }
    
    static void kdistanceNodes(int k, TreeNode target, Map<TreeNode, TreeNode> parentMap,  List<Integer> list, Set<TreeNode> set){
        if(target == null) return;
        if(set.contains(target)) return;
        if(k < 0 ) return;
        if(k ==0) {
            list.add(target.val);
            return;
        }

        set.add(target);
        kdistanceNodes(k-1, target.left, parentMap, list, set);
        kdistanceNodes(k-1, target.right, parentMap, list, set);
        kdistanceNodes(k-1, parentMap.get(target), parentMap, list, set);
    }   

    static void parentNodes(TreeNode parent, TreeNode root, Map<TreeNode, TreeNode> parentMap){
        if(root == null) return;

        parentMap.put(root, parent);
        parentNodes(root, root.left, parentMap);
        parentNodes(root, root.right, parentMap);
    }
}