class Solution {
    public ListNode reverseList(ListNode head) {//head=3
        if(head==null || head.next==null)
            return head;
        ListNode nextNode=head.next;
        ListNode ans=reverseList(nextNode);//5
        nextNode.next=head;//5.next->4
        head.next=null;
        return ans;
    }
}