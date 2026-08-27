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
        if(head==null || head.next==null) return null;
        ListNode reverseHead = reverse(head);
        if(n==1) return reverse(reverseHead.next);
        int count =1;
        ListNode cur = reverseHead;
        while(count < n-1){
           count++;
            cur = cur.next;
        }
        
        ListNode next = cur.next.next;
        cur.next.next = null;
        cur.next = next;

        return reverse(reverseHead);
    }

    static ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode prev = null;

        while(cur!=null){
            head = head.next;
            cur.next = prev;
            prev = cur;
            cur = head;
        } 

        return prev;
    }

}