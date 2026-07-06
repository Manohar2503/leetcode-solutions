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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = reverse(head);
        if(n==1) {
            return reverse(newHead.next);
        }
        ListNode temp = newHead;
        for(int i=1;i<n-1;i++){
            temp = temp.next;
        } 
        ListNode nextNode = temp.next.next;
        temp.next.next = null;
        temp.next = nextNode;
        return reverse(newHead);
    }

    static ListNode reverse(ListNode head){
        if(head==null) return null;
        ListNode prev = null;
        ListNode cur = head;
        while(head!=null){
            head = head.next;
            cur.next = prev;
            prev= cur;
            cur = head;
        }
        return prev;
    }
}