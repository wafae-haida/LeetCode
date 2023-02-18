/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
Understanding:
    1->3->10->5->0->1
    1->3->10->5->0->5->10 is it possible
    1->3->10->5->0->3
    empty
    1->2->1 do we consider this of length 2?
    Questions:
        What is the range length of the linked list?start with 0.
        What is the values range of the linked list?we do have negative value.
Target:
    return true if there is a cycle and false otherways.

Solution:
    I am thinking of using a set that refer to the visited nodes

*/
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null)
            return false;
        Set<ListNode> visited=new HashSet<>();
        ListNode cur=head;
        while(cur!=null){
            if(!visited.add(cur)) return true;
            cur=cur.next;
        }
        return false;
    }
}