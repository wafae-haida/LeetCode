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
      public static ListNode reverse(ListNode head, int left, int right) {
        ListNode pre = null;
        ListNode cur = head; 
        while (right >= left) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            right--;
        }
        return pre;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode cur = head; 
        ListNode nextNode = null;
        ListNode previous = null;
        ListNode reverseHead = null;
        ListNode rightNode = null;
        int count = 1;
        while (count < left && cur != null){
            previous = cur;
            cur = cur.next;
            count++;
        }
        
        if (cur != null) {
            nextNode = cur;
            while (count <= right && nextNode != null) {
                // keep track of the right number node
                rightNode = nextNode;
                nextNode = nextNode.next;
                count++;
            }
            // If we have found the left till right nodes, then we 
            // reverse them.
            if (rightNode != null) {
                // Reverse these [left-right] nodes and get the new head
                //  of the reversed list
                reverseHead = reverse(cur, left, right);
            }

            if (previous != null) {
                // point previous.next to the reversed linked list
                previous.next = reverseHead;
            }

            if (nextNode != null) {
                // traverse in the reversed linked list until the last node
                ListNode tmp = reverseHead;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                // add the next node to the reversed linked list
                tmp.next = nextNode;
            }

        }


        // We will reverse head if there are node before the [left-right]
        // position interval
        if (previous != null)
            return head;
        // We will simply return the reverse head if there is no node
        // before the [left-right] position interval
        else
            return reverseHead;

    }
}