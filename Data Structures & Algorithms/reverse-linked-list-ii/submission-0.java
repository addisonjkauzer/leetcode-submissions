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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0, head);
        Integer numberOfNodes = right - left + 1;
        Integer numberOfSwapsNeeded = numberOfNodes / 2;


        Integer index = 0;
        ListNode iterator = dummyHead;
        while (index != left - 1) {
            iterator = iterator.next;
            index++;
        }
        ListNode leftOfLeftNode = iterator;
        ListNode leftNode = iterator.next;

        while (index != right) {
            iterator = iterator.next;
            index++;
        }
        ListNode rightOfRightNode = iterator.next;


        ListNode currentNode = leftNode;
        ListNode lastNode = rightOfRightNode;

        while (currentNode != rightOfRightNode) {
            ListNode temp = currentNode.next;
            currentNode.next = lastNode;
            lastNode = currentNode;
            currentNode = temp;
        }
        leftOfLeftNode.next = lastNode;

        return dummyHead.next;

    }
}