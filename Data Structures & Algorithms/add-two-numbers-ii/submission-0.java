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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Reverse = reverseLinkedList(l1);
        ListNode l2Reverse = reverseLinkedList(l2);

        ListNode result = new ListNode();
        ListNode iterator = result;
        Integer carry = 0;

        while (l1Reverse != null || l2Reverse != null) {
            Integer l1Value = l1Reverse == null ? 0 : l1Reverse.val;
            Integer l2Value = l2Reverse == null ? 0 : l2Reverse.val;
            Integer sum = l1Value + l2Value + carry;
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            ListNode newValue = new ListNode(sum);
            iterator.next = newValue;
            iterator = iterator.next;

            if (l1Reverse != null) l1Reverse = l1Reverse.next;
            if (l2Reverse != null) l2Reverse = l2Reverse.next;
        }
        if (carry != 0) {
            ListNode newValue = new ListNode(carry);
            iterator.next = newValue;
            iterator = iterator.next;
        }

        return reverseLinkedList(result.next);
    }

    public ListNode reverseLinkedList(ListNode l1) {
        ListNode first = null;
        ListNode second = l1;
        while (second != null) {
            ListNode temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }
        return first;
    }
}