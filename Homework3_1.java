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
class Homework3_1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length < 1){
            return null;
        }
        return merge(lists, 0, lists.length - 1);//只有一个参数不好使用分治法，所以多写一个可以放左右index参数的新方法
    }

    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));//分治法加上普通的合并两个链表的方法
    }

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