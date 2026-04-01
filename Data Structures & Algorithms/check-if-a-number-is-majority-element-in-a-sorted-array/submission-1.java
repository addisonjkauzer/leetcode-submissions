class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        Integer goal = nums.length / 2 + 1;
        for (int num : nums) {
            if (num == target) {
                goal--;
            }
            if (goal == 0) {
                return true;
            }
        }
        return false;
    }
}
