class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));

        ArrayList<int[]> result = new ArrayList<>();
        for (int i =0; i < intervals.length - 1; i++) {
            int[] left = intervals[i];
            int[] right = intervals[i + 1];
            if (left[0] == right[0] || left[1] >= right[0]) {
                intervals[i + 1] = new int[]{Math.min(left[0], right[0]), Math.max(left[1], right[1])};
            } else {
                result.add(left);
            }
        }
        result.add(intervals[intervals.length-1]);
        return result.stream().toArray(int[][]::new);
    }
}
