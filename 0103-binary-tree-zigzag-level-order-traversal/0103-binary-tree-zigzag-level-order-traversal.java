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
        if (root == null)   return new ArrayList<>();

        LinkedList<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        deque.addFirst(root);

        boolean toLeft = false;

        while (deque.size() > 0) {
            int size = deque.size();
            LinkedList<Integer> levelNodes = new LinkedList<>();

            for (int i=0;i<size;i++) {
                TreeNode node = deque.pollFirst();

                if (!toLeft) {
                    levelNodes.addLast(node.val);
                } else {
                    levelNodes.addFirst(node.val);
                }

                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }

            result.add(levelNodes);
            toLeft = !toLeft;
        }

        return result;
    }
}