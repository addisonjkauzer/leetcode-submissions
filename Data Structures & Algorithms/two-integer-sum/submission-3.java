class Solution {
    public int[] twoSum(int[] nums, int target) {
        final HashMap<Integer,Integer> availableNumbers = new HashMap<>();

        for (int i = 0; i< nums.length; i++) {
            final Integer number = nums[i];
            final Integer difference = target - number;
            if (availableNumbers.containsKey(difference)) {
                final Integer firstIndex = availableNumbers.get(difference);
                return new int[]{firstIndex, i};
            }
            availableNumbers.put(number, i);
        }
        throw new RuntimeException("No solution found");
    }
}
