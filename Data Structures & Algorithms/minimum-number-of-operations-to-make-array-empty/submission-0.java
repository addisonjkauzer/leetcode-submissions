class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> numCounter = new HashMap<>();
        for (int num : nums) {
            Integer current = numCounter.getOrDefault(num, 0) + 1;
            numCounter.put(num, current);
        }
        Integer operations = 0;
        for (Integer key : numCounter.keySet()) {
            Integer value = numCounter.get(key);
            if (value == 1) {
                return -1;
            }

            if (value % 3 == 0) {
                operations += value / 3;
            }
            if (value % 3 == 1) {
                operations += (value - 3 >= 0 ? value -3 : 0) / 3 + 2;
            }
            if (value % 3 == 2) {
                operations += value / 3 + 1;
            }
        }
        return operations;
    }
}