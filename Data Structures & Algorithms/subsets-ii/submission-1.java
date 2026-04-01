class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();

        backtracking(nums, 0, subset, result);

        return new ArrayList(result);
        
    }

    public void backtracking(int[] nums, int index, List<Integer> subset, Set<List<Integer>> result) {
        if (index >= nums.length) {
            List<Integer> sortedList = new ArrayList(subset);
            Collections.sort(sortedList);
            result.add(sortedList);
            return;
        }
        List<Integer> sortedList = new ArrayList(subset);
        Collections.sort(sortedList);
        result.add(sortedList);
        //Take Index
        subset.add(nums[index]);
        backtracking(nums, index + 1, subset, result);

        //Don't take Index
        subset.remove(subset.size() - 1);
        backtracking(nums, index + 1, subset, result);
    }
}
