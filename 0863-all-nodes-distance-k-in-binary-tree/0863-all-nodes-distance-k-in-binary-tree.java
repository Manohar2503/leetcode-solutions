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
        Map<TreeNode , TreeNode> map = new HashMap<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            TreeNode node = qu.poll();
            if(node.left!=null) {
                map.put(node.left,node);
                qu.offer(node.left);
            }
            if(node.right!=null) {
                map.put(node.right,node);
                qu.offer(node.right);
            }
        }

        Map<TreeNode,Boolean> map2 = new HashMap<>();
        Queue<TreeNode> qu2 = new LinkedList<>();
        qu2.offer(target);
        map2.put(target,true);
        int count =0;
        while(!qu2.isEmpty()){
            if(count == k) break;
            int size = qu2.size();
            for(int i=0;i<size;i++){
                TreeNode node = qu2.poll();
                 if(node.left!=null && !map2.containsKey(node.left)) {
                map2.put(node.left,true);
                qu2.offer(node.left);
            }
            if(node.right!=null && !map2.containsKey(node.right)) {
                map2.put(node.right,true);
                qu2.offer(node.right);
            }
            TreeNode parent = map.get(node);
            if(parent!=null && !map2.containsKey(parent)){
                map2.put(parent,true);
                qu2.offer(parent);
            }
            }
            count++;
           
        }

        List<Integer> list = new ArrayList<>();
        while(!qu2.isEmpty()){
            TreeNode node = qu2.poll();
            list.add(node.val);
        }
        return list;
    }
}