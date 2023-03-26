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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prev = head; 
		int len = 2; 
		while(prev.next != null){
			ListNode node = prev;
            int n =0;
			for (int i = 0; i < len; i ++){
				if(node.next == null)
                    break;
				node=node.next;
                n++;
			}
			if(n % 2 != 0)
			   prev = node; 
			else{
				ListNode reverse = node.next;
				ListNode curr = prev.next;
                for(int j=0; j < n;j++){
                    ListNode nodeNext = curr.next;
				    curr.next = reverse;
				    reverse = curr;
				    curr = nodeNext;
                }
                ListNode prevNext = prev.next;
				prev.next = node;
			    prev = prevNext;
			}
			len++;
		}
	    return head;
    }
   
}