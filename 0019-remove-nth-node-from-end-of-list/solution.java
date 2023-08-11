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
        int counter = 1;
        ListNode pointer = head;
        while (pointer.next != null) {
            counter++;
            pointer = pointer.next;
        }
        if (counter == 1) {
            return null;
        }
        int index = counter - n + 1;
        if (index == 1) {
            return head.next;
        }
        System.out.println(index);
        pointer = head;

        for (int i =1; i < index - 1; i++) {
            pointer = pointer.next;
        }
        if (pointer.next == null) {
            pointer = null;
        } else {
            pointer.next = pointer.next.next;
        }

        return head;
        
    }
}