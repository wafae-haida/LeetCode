/*
Understanding:
        1->2->3->5
        6->8->9->10->11
        -----
        null
        1
        ----
        null
        null
        --
        1->2
        null
        ---
        1->2->3
        1->2->3->4 
            result:
                1->1->2->2->3->3->4
    Questions:
        Do the two list has the same length? No.
            If not what is the range of each one? [0,50]
        What is the values range of each list?[-100,100]
        If i found redandant values what should i do in this case?asc order, Yes.
        
Target:
    merge two sorted list to get one sorted list.
    return the head of the final sorted list.
    
Solution:
    Since the lists are sorted i'll start by comparing the value of the head of each one of them.
    I'm thinking of using the recursion method
    the base case is if one of the head is null return the other list
*/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        if(list1.val<list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next=mergeTwoLists(list2.next,list1);
            return list2;
        }
    }
}