class Solution {
    public int largestUniqueNumber(int[] nums) {
        HashMap<Integer,Integer> counter = new HashMap<>();

        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        int result = -1;
        for (int key : counter.keySet()) {
            if (counter.get(key) == 1) {
                result = Math.max(result, key);
            }
        }
        return result;
        
    }
}
