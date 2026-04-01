class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        getAllOrderings(nums, new HashSet<>(), new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    public void getAllOrderings(int[] nums, Set<Integer> selectedIndexes, List<Integer> runningPermutation, Set<List<Integer>> result) {
        if (runningPermutation.size() == nums.length) {
            result.add(new ArrayList<>(runningPermutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (selectedIndexes.contains(i)) {
                continue;
            }
            selectedIndexes.add(i);
            runningPermutation.add(nums[i]);
            getAllOrderings(nums, selectedIndexes, runningPermutation, result);
            runningPermutation.remove(runningPermutation.size() -1);
            selectedIndexes.remove(i);
        }
    }
}