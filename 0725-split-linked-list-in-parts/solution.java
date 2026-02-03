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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode iterator = head;
        Integer totalNodes = 0;

        while (iterator != null) {
            totalNodes++;
            iterator = iterator.next;
        }

        Integer minGroupSize = totalNodes / k;
        Integer extras = totalNodes % k;

        Integer[] resultSize = new Integer[k];
        for (int i = 0; i < resultSize.length; i++) {
            resultSize[i] = minGroupSize;
            if (extras > 0) {
                resultSize[i]++;
                extras--;
            }
        }


        ListNode[] result = new ListNode[k];
        iterator = head;
        
        for (int i = 0; i < result.length; i++) {
            result[i] = iterator;
            for (int j = 0; j < resultSize[i] - 1; j++) {
                iterator = iterator.next;
            }
            if (iterator == null) {
                break;
            }
            ListNode temp = iterator.next;
            iterator.next = null;
            iterator = temp;
        }
        return result;
    }
}