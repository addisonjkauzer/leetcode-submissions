class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        Integer count = 0;

        for (int i = 0; i < intervals.length -1; i++) {
            int[] left = intervals[i];
            int[] right = intervals[i+1];
            if (left[0] == right[0] || left[1] > right[0]) {
                if (left[1] < right[1]) {
                    intervals[i+1] = left;
                } else {
                    intervals[i+1] = right;
                }
                count++;
            }
        }
        return count;
    }
}
