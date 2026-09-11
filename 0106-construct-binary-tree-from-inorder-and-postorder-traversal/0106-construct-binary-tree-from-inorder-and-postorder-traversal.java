class Solution {
    static int postLen;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postLen = postorder.length - 1;
        return constructTree(inorder, postorder, 0, inorder.length - 1);
    }

    static TreeNode constructTree(int[] inorder, int[] postorder,
                                  int inLeft, int inRight) {

        if (inLeft > inRight) {
            return null;
        }

        int rootValue = postorder[postLen--];

        TreeNode root = new TreeNode(rootValue);

        int rootIndex = findRoot(inorder, rootValue, inLeft, inRight);

        // IMPORTANT: build right first
        root.right = constructTree(inorder, postorder,
                                    rootIndex + 1, inRight);

        root.left = constructTree(inorder, postorder,
                                   inLeft, rootIndex - 1);

        return root;
    }

    static int findRoot(int[] inorder, int root, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == root) {
                return i;
            }
        }
        return -1;
    }
}