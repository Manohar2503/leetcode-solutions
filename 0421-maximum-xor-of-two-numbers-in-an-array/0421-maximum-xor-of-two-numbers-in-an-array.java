class Solution {

    static class Node {
        Node[] child = new Node[2];
    }
    static Node root;
    public int findMaximumXOR(int[] nums) {
        root = new Node();
        // Build trie
        for (int num : nums) {
            construct(num);
        }
        int result = 0;
        for (int num : nums) {
            result = Math.max(result, maxXor(num));
        }
        return result;
    }

    static void construct(int val) {
        Node cur = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (val >>> i) & 1;
            if (cur.child[bit] == null) {
                cur.child[bit] = new Node();
            }
            cur = cur.child[bit];
        }
    }

    static int maxXor(int val) {

        Node cur = root;
        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (val >>> i) & 1;
            int opposite = bit ^ 1;
            if (cur.child[opposite] != null) {
                ans |= (1 << i);
                cur = cur.child[opposite];
            } else {
                cur = cur.child[bit];
            }
        }
        return ans;
    }
}