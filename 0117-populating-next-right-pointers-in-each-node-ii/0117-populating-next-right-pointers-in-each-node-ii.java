class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        if (root.right != null) {
            root.right.next = findNext(root.next);
        }

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findNext(root.next);
            }
        }

        connect(root.right);
        connect(root.left);

        return root;
    }

    private Node findNext(Node node) {
        while (node != null) {
            if (node.left != null) {
                return node.left;
            }

            if (node.right != null) {
                return node.right;
            }

            node = node.next;
        }

        return null;
    }
}