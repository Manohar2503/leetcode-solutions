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
    static int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i], i);
        }
        index = n-1;
        return build(0, n-1, inorder, postorder, map);
    }

    static TreeNode build(int start, int end, int[] inorder, int[] postorder, Map<Integer, Integer> map){
        if(start > end) return null;
        if(index < 0) return null;

        int value = postorder[index];
        int pos = map.get(value);
        TreeNode root = new TreeNode(postorder[index--]);

        root.right = build(pos+1, end, inorder, postorder, map);
        root.left = build(start, pos-1, inorder, postorder, map);
    
        return root;
    }
}
/**
                       I
    post - > 9 15 7 20 3
             M
    in - > 9 3 15 20 7

*/