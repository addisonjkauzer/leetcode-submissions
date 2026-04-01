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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currentNode = head;

        Integer counter = -1;

        while (currentNode != null) {
            counter++;
            currentNode = currentNode.next;
        }

        Integer indexToRemove = counter - n + 1;
        if (indexToRemove == 0) {
            return head.next;
        }

        ListNode nodeBeforeRemove = head;

        for (int i = 0; i < indexToRemove - 1; i++) {
            nodeBeforeRemove = nodeBeforeRemove.next;
        }
        if (nodeBeforeRemove.next == null) {
            return null;
        } else {
            nodeBeforeRemove.next = nodeBeforeRemove.next.next;
        }
        return head;

    }
}
