class Solution {
    public boolean hasDuplicate(int[] nums) {
        final HashSet<Integer> uniques = new HashSet<>();

        for (final Integer num : nums) {
            uniques.add(num);
        }
        
        if (uniques.size() == nums.length) {
            return false;
        }
        return true;
    }
}