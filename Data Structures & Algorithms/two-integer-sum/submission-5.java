class Solution {
    public int[] twoSum(int[] nums, int target) {
        final HashMap<Integer, Integer> goalNumbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            goalNumbers.put(target - num, i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            if (goalNumbers.keySet().contains(num) && i != goalNumbers.get(num)) {
                return new int[]{i, goalNumbers.get(num)};
            }
        }
        return new int[2];
    }
}
