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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head;
        if (list1.val >= list2.val) {
            head = list2;
            list2 = list2.next;
        } else {
            head = list1;
            list1 = list1.next;
        }

        ListNode builder = head;

        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                builder.next = list2;
                list2 = list2.next;
            } else {
                builder.next = list1;
                list1 = list1.next;
            }
            builder = builder.next;
        }

        if (list1 == null) {
            builder.next = list2;
        }
        if (list2 == null) {
            builder.next = list1;
        }
        return head;
    }
}