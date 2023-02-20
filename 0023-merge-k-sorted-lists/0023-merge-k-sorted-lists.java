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
----------
if k=1 or k=0, return that list
--------------

ans=empty
two list(ans,lists[0])
ans=1->1->1->2->2->3->3->4->4->8 ;
    3<4
cur=8
secCur=null
pre=4
loop(secCur!=null)
    if(cur<=secCur)
        pre=cur
        cur=cur.next
        continue
    else
tmp=cur
pre.next=secCur
pre.next.next=tmp
pre=pre.next
secCur=secCur.next
if(cur==null)
pre.next=secCur
secCur=secCur.next
-----------
1->1->2->2->3->3->4->4->8
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       if(lists.length==0) return null;
        return mergeSortLists(lists,0,lists.length-1);
    }
    public ListNode mergeSortLists(ListNode[] lists,int left,int right){
        if(left==right) return lists[left];
        int mid=left+(right-left)/2;
        ListNode leftList=mergeSortLists(lists,left,mid);
        ListNode rightList=mergeSortLists(lists,mid+1,right);
        return merge(leftList,rightList);
    }
    public ListNode merge(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                tail.next=list1;
                list1=list1.next;
            }else{
                tail.next=list2;
                list2=list2.next;
            }
            tail=tail.next;
        }
        tail.next=list1==null?list2:list1;
        return dummy.next;
    }
}
