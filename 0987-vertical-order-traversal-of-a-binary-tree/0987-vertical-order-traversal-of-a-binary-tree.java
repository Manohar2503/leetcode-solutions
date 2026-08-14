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
        int row;
        int col;
        int val;
        Node(int r, int c, int v){
            this.row = r;
            this.col = c;
            this.val = v;
        }
    } 
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        TreeMap<Integer, List<Node>> map= new TreeMap<>();
        dfs(0,0,root, map);
        for(Map.Entry<Integer, List<Node>> entry: map.entrySet()){
            List<Node> sublist = entry.getValue();
            sublist.sort((a,b)->{
                if(a.row!=b.row) return a.row-b.row;
                return a.val-b.val;
            });
            List<Integer> newList = new ArrayList<>();
            for(Node n: sublist){
                newList.add(n.val);
            }
            result.add(newList);
        }
        return result;
    }
    static void dfs(int row, int col, TreeNode node, TreeMap<Integer, List<Node>> map){
        if(node == null) return;
        map.computeIfAbsent(col, k-> new ArrayList<>()).add(new Node(row,col,node.val));
        dfs(row+1, col-1, node.left, map);
        dfs(row+1, col+1, node.right, map);
    }
}