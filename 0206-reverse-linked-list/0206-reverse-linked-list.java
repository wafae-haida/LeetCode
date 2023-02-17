class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode pre=null;
        ListNode ans=null;
        while(cur!=null){
            pre=ans;//4
            ans=cur;//5
            cur=cur.next;//null
            ans.next=pre;//4->3->2->1
        }
        return ans;
    }
}
 