class Solution {
    HashMap <Integer, Integer> previouslyComputed = new HashMap();
    public int rob(int[] nums) {
        return robFromIndex(nums, 0);
    }

    private int robFromIndex(int[] nums, int index) {
        if (previouslyComputed.containsKey(index)) {
            return previouslyComputed.get(index);
        }
        if (index == nums.length - 1) {
            return nums[index];
        }
        if (index > nums.length -1 ) {
            return 0;
        }
        int currentHouseScore = nums[index] + robFromIndex(nums, index+2);
        int skipHouseScore = robFromIndex(nums, index +1);

        int totalScore = Math.max(currentHouseScore, skipHouseScore);
        previouslyComputed.put(index, totalScore);
        return totalScore;
    }
}