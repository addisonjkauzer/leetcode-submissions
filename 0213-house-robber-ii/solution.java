class Solution {
    HashMap <Integer, Integer> previouslyComputedWithFirst = new HashMap();
    HashMap <Integer, Integer> previouslyComputedWithoutFirst = new HashMap();
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robFromIndex(nums, 0, true), robFromIndex(nums, 1, false));
    }

    private int robFromIndex(int[] nums, int index, boolean withFirstHouse) {
        if (withFirstHouse) {
            if (previouslyComputedWithFirst.containsKey(index)) {
                return previouslyComputedWithFirst.get(index);
            }
        }
        if (!withFirstHouse) {
            if (previouslyComputedWithoutFirst.containsKey(index)) {
                return previouslyComputedWithoutFirst.get(index);
            }
        }
        if (index == nums.length - 1) {
            if (withFirstHouse) {
                return 0;
            } else {
                return nums[index];
            }
        }
        if (index > nums.length -1 ) {
            return 0;
        }
        int currentHouseScore = nums[index] + robFromIndex(nums, index+2, withFirstHouse);
        int skipHouseScore = robFromIndex(nums, index + 1, withFirstHouse);

        int totalScore = Math.max(currentHouseScore, skipHouseScore);
        if (withFirstHouse) {
            previouslyComputedWithFirst.put(index, totalScore);
        }
        if (!withFirstHouse) {
            previouslyComputedWithoutFirst.put(index, totalScore);
        }
        return totalScore;
    }
}