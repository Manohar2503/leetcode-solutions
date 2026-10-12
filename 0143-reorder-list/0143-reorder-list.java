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
    public void reorderList(ListNode head) {
        ListNode temp  = head;
        ListNode node = head;
        while(node.next!=null){
            
            while(temp.next.next!=null && temp.next!=null){
                temp = temp.next;
            }
            if(node==temp) return;
            ListNode left = node.next;
            node.next = temp.next;
            node.next.next= left;
            temp.next=null;
            node=left;
            temp=node;
        }
    }
}