class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        TreeMap<Integer, Integer> intervalMap = new TreeMap<>();
        intervalMap.put(0, null);

        for (int[] interval : intervals) {
            Integer intervalLength = interval[1] - interval[0] + 1;
            Integer previousAfterInterval = getCurrentValue(interval[1] + 1, intervalMap);

            Integer currentValue = getCurrentValue(interval[0], intervalMap);
            if (currentValue == null || currentValue > intervalLength) {
                intervalMap.put(interval[0], intervalLength);
            }

            Integer keyInRange = intervalMap.floorKey(interval[1]);
            while(keyInRange > interval[0]) {
                currentValue = intervalMap.get(keyInRange);
                if (currentValue == null || currentValue > intervalLength) {
                    intervalMap.put(keyInRange, intervalLength);
                }
                keyInRange = intervalMap.floorKey(keyInRange - 1);
            }
            intervalMap.put(interval[1] + 1, previousAfterInterval);
        }
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            Integer value = getCurrentValue(queries[i], intervalMap);
            result[i] = value == null ? -1 : value;
        }
        return result;
    }

    public Integer getCurrentValue(Integer key, TreeMap<Integer, Integer> map) {
        return map.get(map.floorKey(key));
    }
}
