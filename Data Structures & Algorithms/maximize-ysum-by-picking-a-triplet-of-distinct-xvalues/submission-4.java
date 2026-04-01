class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        HashMap<Integer, Integer> xValueToMaxY = new HashMap<>();

        for (int i = 0; i < x.length; i++) {
            Integer newValue = Math.max(y[i], xValueToMaxY.getOrDefault(x[i], -1));
            xValueToMaxY.put(x[i], newValue);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer value : xValueToMaxY.values()) {
            if (minHeap.size() < 3) {
                minHeap.offer(value);
            } else if (value > minHeap.peek()) {
                minHeap.remove();
                minHeap.offer(value);
            }
        }
        if (xValueToMaxY.keySet().size() < 3) {
            return -1;
        }
        return minHeap.stream().mapToInt(Integer::intValue).sum();
    }
}