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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode iterator = head;
        ListNode nodeBeforeHead = new ListNode(-1);
        ListNode endOfPrevious = nodeBeforeHead;
        while (iterator != null) {
            ListNode startOfFirst = iterator;
            Integer counter = 1;
            while (counter < k && iterator != null) {
                counter++;
                iterator = iterator.next;
            }
            if (iterator == null) {
                endOfPrevious.next = startOfFirst;
                continue;
            }
            ListNode endOfFirst = iterator;
            iterator = iterator.next;
            ListNode startOfSecond = iterator;

            endOfFirst.next = null;
            ListNode temp = reverse(startOfFirst);
            endOfFirst = startOfFirst;
            startOfFirst = temp;

            endOfFirst.next = startOfSecond;
            endOfPrevious.next = startOfFirst;
            endOfPrevious = endOfFirst;
        }
        return nodeBeforeHead.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            final ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }
}
