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
    static{
        for(int i=0; i<=500;i++){
            new Solution().reorderList(null);
        }
    }
    public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode SecH = slow.next;
        slow.next = null;

        ListNode curr = SecH;
        ListNode prev = null;
        while(curr!=null){
            ListNode nextnode = curr.next;
            curr.next =prev;
            prev= curr;
            curr=nextnode;
        }
        ListNode t1= head;
        ListNode t2 = prev;
        while(t2!=null){
            ListNode m1 = t1.next;
            ListNode m2 = t2.next;
            t1.next = t2;
            t2.next = m1;

            t1= m1;
            t2= m2;


        }
        
    }
}