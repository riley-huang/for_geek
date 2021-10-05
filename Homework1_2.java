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
class Homework1_2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 != null && l2 == null){
            return l1;
        }else if(l1 == null && l2 != null){
            return l2;
        }else{
            ListNode pre = new ListNode(-101);
            ListNode ans = pre;
            while(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    ans.next = l1;
                    l1 = l1.next;
                }else{
                    ans.next = l2;
                    l2 = l2.next;
                }
                ans = ans.next;
            }
            ans.next = l1 == null? l2 : l1;
            return pre.next;
        }
    }
}