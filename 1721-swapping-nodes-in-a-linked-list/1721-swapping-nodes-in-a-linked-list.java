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
    public ListNode swapNodes(ListNode head, int k) {
        int count =0;
        if(head == null) return null;

        ListNode node = head;
        while(node != null){
            count++;
            node = node.next;
        }

        if(count < k) return head;
        int last = count - k+1;

        ListNode first = null;
        ListNode end = null;
        node = head;

        for(int i=1;i<=count;i++){
            if(i == k) first = node;
            if(i == last) end = node;
            node = node.next;
        }

        int value = first.val;
        first.val = end.val;
        end.val = value;

        return head;
    }
}
/*  
    0 1 2 3 4 5 6 7 8 9
    7 9 6 6 7 8 3 0 9 5
            k      

*/