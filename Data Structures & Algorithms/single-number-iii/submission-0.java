class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            int newCount = counter.getOrDefault(num, 0) + 1;
            if (newCount == 2) {
                counter.remove(num);
            } else {
                counter.put(num, newCount);
            }
        }
        return counter.keySet().stream().mapToInt(a -> a).toArray();
    }
}