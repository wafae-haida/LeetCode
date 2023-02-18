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
------
    1
        Result:
            1.
    ---
    2->1
        Result:
            2->1.
    ---
    5->3->10->5->100
        Result:
            5->100->3->5->10.
    Questions:
    What is the range of the lenght of the input? at least we have a node which means the first node is not null
    Am I supposed to ignore the values and care about the position first->end->nextfirst->preend->...
    
Target:
    0->...->n
    0->n->1->n-1->....
    Don't return anything just reorder the input in the following way.

Solution:
    I will use Recursion:
        The base case is if head.next==null

*/
class Solution {
    public void reorderList(ListNode head){
        List<ListNode> listNode=new ArrayList<>();
        ListNode cur=head;
        while(cur!=null){
            listNode.add(cur);
            cur=cur.next;
        }
        int left=0,right=listNode.size()-1;
        List<ListNode> listRes=new ArrayList<>();
        while(left<=right){
            listRes.add(listNode.get(left));
            listRes.add(listNode.get(right));
            left++;
            right--;
        }
        ListNode tmp=null;
        for(int i=0;i<listRes.size()-1;i++){
            head=tmp;
            tmp=listRes.get(i);
            tmp.next=null;
            tmp.next=listRes.get(i+1);
            tmp.next.next=null;
        }
    }
}