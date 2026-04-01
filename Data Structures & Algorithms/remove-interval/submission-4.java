class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // removed encompases interval
            if (left >= toBeRemoved[0] && right <= toBeRemoved[1]) {
                continue;
            } else
            // interval encompases removed
            if (left < toBeRemoved[0] && right > toBeRemoved[1]) {
                result.add(Arrays.asList(left, toBeRemoved[0]));
                result.add(Arrays.asList(toBeRemoved[1], right));
            } else
            
            // right of interval overlaps with toBeRemoved 
            if (left <= toBeRemoved[1] && right > toBeRemoved[1]) {
                result.add(Arrays.asList(toBeRemoved[1], right));
            } else

            // left of interval overlaps with toBeRemoved
            if (left <= toBeRemoved[0] && right > toBeRemoved[0]) {
                result.add(Arrays.asList(left, toBeRemoved[0]));
            } else

            //interval entirely to the left or right
            if (right < toBeRemoved[0] || left >= toBeRemoved[1]) {
                result.add(Arrays.asList(left, right));
            }
        }
        return result;
    }
}
