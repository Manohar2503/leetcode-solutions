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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode list1 = reverse(l1);
        ListNode list2 = reverse(l2);

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carry =0;
        int sum =0;

        while(list1!=null || list2!=null){
            sum = carry;
            if(list1!=null) sum += list1.val;
            if(list2!=null) sum += list2.val;

            ListNode newNode = new ListNode(sum % 10);
            current.next = newNode;
            current = newNode;
            carry = sum / 10;
            if(list1!=null) list1 = list1.next;
            if(list2!=null) list2 = list2.next;
        }
        if(carry!=0){
            ListNode newone = new ListNode(carry);
            current.next = newone;
        }
        return reverse(dummy.next);
    }

    static ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode current = node;

        while(node!=null){
            node = node.next;
            current.next = prev;
            prev = current;
            current = node;
        }

        return prev;
    }
}