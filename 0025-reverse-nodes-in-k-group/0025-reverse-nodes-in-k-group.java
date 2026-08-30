/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        int count = 0;
        ListNode dummy = head;
        
        while(dummy!=null && count<k){
            dummy = dummy.next;
            count++;
        }

        if(count <k) return head;
        ListNode prev = head;
        ListNode node = head;
        ListNode tail = head;
        for(int i=0;i<k;i++){
            head = head.next;
            node.next = prev;
            prev = node;
            node = head;
        }

        tail.next = reverseKGroup(node, k);
        return prev;
    }
}