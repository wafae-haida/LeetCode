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
        if(head == null || head.next == null) {
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // find the middle node of the list
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the second half of the list
        ListNode prev = null;
        ListNode cur = slow.next;
        slow.next = null;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        // merge the two halves of the list
        ListNode p1 = head;
        ListNode p2 = prev;
        while(p2 != null) {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;
        }
    }
}
