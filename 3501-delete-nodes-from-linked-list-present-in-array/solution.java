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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> toBeRemoved = new HashSet<>();
        for (int num : nums) {
            toBeRemoved.add(num);
        }

        while (head != null && toBeRemoved.contains(head.val)) {
            head = head.next;
        }
        ListNode iterator = head;
        while (iterator != null && iterator.next != null) {
            while (iterator.next != null && toBeRemoved.contains(iterator.next.val)) {
                removeNextNode(iterator);
            }
            iterator = iterator.next;
        }
        return head;
        
    }


    public void removeNextNode(ListNode head) {
        head.next = head.next.next;
    }
}