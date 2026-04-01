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
    public ListNode mergeKLists(ListNode[] lists) {
        final TreeMap<Integer, List<ListNode>> sortedMap = new TreeMap<>();

        for (final ListNode node : lists) {
            final List<ListNode> existingList = sortedMap.getOrDefault(node.val, new ArrayList<>());
            existingList.add(node);
            sortedMap.put(node.val, existingList);
        }
        if (sortedMap.keySet().isEmpty()) {
            return null;
        }

        List<ListNode> lowestList = sortedMap.get(sortedMap.firstKey());
        final ListNode head = lowestList.get(0);
        lowestList.remove(0);
        if (lowestList.isEmpty()) {
            sortedMap.remove(sortedMap.firstKey());
        } else {
            sortedMap.put(sortedMap.firstKey(), lowestList);
        }

        if (head.next != null) {
            final List<ListNode> existingList = sortedMap.getOrDefault(head.next.val, new ArrayList<>());
            existingList.add(head.next);
            sortedMap.put(head.next.val, existingList);
        }

        ListNode iterator = head;

        while (!sortedMap.keySet().isEmpty()) {
            lowestList = sortedMap.get(sortedMap.firstKey());
            final ListNode smallestNode = lowestList.get(0);
            iterator.next = smallestNode;

            lowestList.remove(0);
            if (lowestList.isEmpty()) {
                sortedMap.remove(sortedMap.firstKey());
            } else {
                sortedMap.put(sortedMap.firstKey(), lowestList);
            }

            if (smallestNode.next != null) {
                final List<ListNode> existingList = sortedMap.getOrDefault(smallestNode.next.val, new ArrayList<>());
                existingList.add(smallestNode.next);
                sortedMap.put(smallestNode.next.val, existingList);
            }

            iterator = iterator.next;
        }

        return head;
    }
}
