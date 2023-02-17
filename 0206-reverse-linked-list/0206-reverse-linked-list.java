class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode pre=null;
        ListNode post=null;
        while(cur!=null){
            post=pre;
            pre=cur;
            cur=cur.next;
            pre.next=post;
        }
        return pre;
    }
}