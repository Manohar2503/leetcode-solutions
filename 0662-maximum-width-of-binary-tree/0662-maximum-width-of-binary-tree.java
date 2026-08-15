class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        List<Long> firstIndex = new ArrayList<>();
        return dfs(root, 0, 0L, firstIndex);
    }

    private int dfs(TreeNode node, int depth, long index, List<Long> firstIndex) {
        if (node == null) return 0;

        // record first index at this depth
        if (firstIndex.size() == depth) {
            firstIndex.add(index);
        }

        int currentWidth = (int) (index - firstIndex.get(depth) + 1);

        int leftWidth = dfs(node.left, depth + 1, 2L * index, firstIndex);
        int rightWidth = dfs(node.right, depth + 1, 2L * index + 1L, firstIndex);

        return Math.max(currentWidth, Math.max(leftWidth, rightWidth));
    }
}
