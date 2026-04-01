class Solution {
    public boolean hasDuplicate(int[] nums) {
        final HashSet<Integer> withoutDuplicates = new HashSet<>();
        for (int num : nums) {
            withoutDuplicates.add(num);
        }
        if (withoutDuplicates.size() == nums.length) {
            return false;
        }
        return true;
    }
}