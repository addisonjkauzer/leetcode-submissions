class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Integer num : counter.keySet()) {
            if (counter.get(num) > nums.length / 3) {
                result.add(num);
            }
        }
        return result;
    }
}