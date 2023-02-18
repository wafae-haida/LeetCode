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
/*
Understanding:
    1->2->3->4->5,indx-1=2
    ---
    5,1
    Questions:
        What is the length range of the linkedlist?[1,30]
        Does indx always exist in the linkedlist?[1,length]yes
        What is the range of its values?[0,100]
Target:
    remove the indx from the linkedlist and return the head
Solution:
    I will go throught the linkedlist when i found the node i will link its pre node to its pot node
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) 
            return null;
        ListNode tmp=new ListNode(0);
        tmp.next=head;
        ListNode fast=tmp;
        ListNode slow=tmp;
        while(n>0){
            fast=fast.next;
            n--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return tmp.next;
    }
}