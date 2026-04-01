class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> buckets = new TreeMap<>();
        for (Integer num : count.keySet()) {
            Integer numCount = count.get(num);
            buckets.computeIfAbsent(numCount, a -> new ArrayList<>()).add(num);
        }

        List<Integer> result = new ArrayList<>();

        for (Integer numCount : buckets.keySet()) {
            List<Integer> numsAtCount = buckets.get(numCount);
            Collections.sort(numsAtCount, Collections.reverseOrder());
            for (Integer numAtCount : numsAtCount) {
                for (int i = 0; i < numCount; i++) {
                    result.add(numAtCount);
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
        
    }
}