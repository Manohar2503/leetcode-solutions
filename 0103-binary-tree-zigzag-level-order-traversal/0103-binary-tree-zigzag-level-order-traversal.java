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
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Deque<TreeNode> qu = new ArrayDeque<>();
        qu.offerFirst(root);
        boolean isLeft = true;

        while(!qu.isEmpty()){
            int size = qu.size();
            LinkedList<Integer> list = new LinkedList<>();

            for(int i=0;i<size;i++){
                TreeNode node = qu.poll(); 
                if(isLeft){
                    list.offerLast(node.val);
                }
                else{
                    list.offerFirst(node.val);
                }
                
                if(node.left!=null) qu.offer(node.left);
                if(node.right!=null) qu.offer(node.right);
            }

            isLeft = !isLeft;
            result.add(list);
        }

        return result;
    }
}