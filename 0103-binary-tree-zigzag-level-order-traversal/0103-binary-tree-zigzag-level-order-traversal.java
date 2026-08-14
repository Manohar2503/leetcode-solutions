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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        boolean isLeft = true;
        while(!qu.isEmpty()){
            int size = qu.size();
            LinkedList<Integer> sublist = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode node = qu.poll();
                if(isLeft) sublist.addLast(node.val);
                else sublist.addFirst(node.val);
                if(node.left!=null) qu.offer(node.left);
                if(node.right!=null) qu.offer(node.right);
            }
            isLeft = !isLeft;
            list.add(sublist);
        }
        return list;
    }
}