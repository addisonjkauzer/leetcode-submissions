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
        final StringBuilder l1StringBuilder = new StringBuilder();
        final StringBuilder l2StringBuilder = new StringBuilder();

        while(l1 != null) {
            l1StringBuilder.insert(0, Integer.toString(l1.val));
            l1 = l1.next;
        }

        while(l2 != null) {
            l2StringBuilder.insert(0, Integer.toString(l2.val));
            l2 = l2.next;
        }

        final Integer l1Integer = Integer.parseInt(l1StringBuilder.toString());
        final Integer l2Integer = Integer.parseInt(l2StringBuilder.toString());

        final Integer sumInteger = l1Integer + l2Integer;

        final String sumString = Integer.toString(sumInteger);

        final ListNode newHead = new ListNode(Integer.parseInt(sumString.substring(sumString.length() - 1, sumString.length())));
        ListNode iterator = newHead;

        for (int i = sumString.length() - 2; i >= 0; i--) {
            final ListNode newNext = new ListNode(Integer.parseInt(sumString.substring(i, i + 1)));
            iterator.next = newNext;
            iterator = iterator.next;
        } 

        return newHead;
        
    }
}
