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
    public boolean canAttendMeetings(List<Interval> intervals) {

        intervals.sort(Comparator.comparing(a -> a.start));

        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval left = intervals.get(i);
            Interval right = intervals.get(i+1);
            if (left.end > right.start) {
                return false;
            }
        }
        return true;

    }
}
