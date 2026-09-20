class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list
        ListNode right = slow.next;
        slow.next = null;

        // Reverse second half
        ListNode prev = null;
        ListNode node = right;

        while (node != null) {
            right = right.next;
            node.next = prev;
            prev = node;
            node = right;
        }

        // Merge
        ListNode left = head;
        right = prev;

        while (left != null && right != null) {
            ListNode rightNode = right;
            right = right.next;

            ListNode leftNode = left;
            left = left.next;

            leftNode.next = rightNode;
            rightNode.next = left;
        }
    }
}