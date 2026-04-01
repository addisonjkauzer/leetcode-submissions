class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final HashMap<Integer, Integer> counter = new HashMap<>();

        for (final Integer number : nums) {
            counter.put(number, counter.getOrDefault(number, 0) + 1);
        }

        final TreeMap<Integer, List<Integer>> bucketSort = new TreeMap<>();
        for (final Integer key : counter.keySet()) {
            final Integer count = counter.get(key);
            final List<Integer> bucket = bucketSort.getOrDefault(count, new ArrayList<>());
            bucket.add(key);
            bucketSort.put(count, bucket);
        }

        System.out.println(bucketSort);
        int[] topKFrequent = new int[k];
        int count = 0;
        for (final Integer key : bucketSort.descendingKeySet()) {
            final List<Integer> bucket = bucketSort.get(key);
            for (final Integer item : bucket) {
                topKFrequent[count] = item;
                count++;
                if (count >= k) {
                    return topKFrequent;
                }
            }
        }
        return topKFrequent;
    }
}
