/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparing(a -> a.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Integer days = 0;

        for (int i = 0; i < intervals.size(); i++) {
            Interval left = intervals.get(i);
            if (!minHeap.isEmpty() && minHeap.peek() <= left.start) {
                minHeap.remove();
            }
            minHeap.add(left.end);
        }
        return minHeap.size();

    }    
}
