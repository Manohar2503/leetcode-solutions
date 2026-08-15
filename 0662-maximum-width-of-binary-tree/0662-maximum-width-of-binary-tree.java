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
    static class Node{
        TreeNode node;
        long pos;
        Node(TreeNode node, long pos){
            this.node = node;
            this.pos = pos;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Node> qu = new LinkedList<>();
        qu.offer(new Node(root,0));
        long result =0;
        while(!qu.isEmpty()){
            int size = qu.size();
            long firstPos = qu.peek().pos;
            long lastPos = firstPos;
        
            for(int i=0;i<size;i++){
                Node currentNode = qu.poll();
                long pos = currentNode.pos - firstPos;
                lastPos = pos;
                if(currentNode.node.left !=null) qu.offer(new Node(currentNode.node.left, (2    * pos) +1));
                if(currentNode.node.right !=null) qu.offer(new Node(currentNode.node.right, (2 * pos) +2));            
                }
            result = Math.max(result, lastPos +1);
        }

        return (int)result;
    }
}