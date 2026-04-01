class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, subset, result);

        return result;
        
    }

    public void dfs(int[] nums, Integer index, List<Integer> subset, List<List<Integer>> result) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(subset));
        } else {
            subset.add(nums[index]);
            dfs(nums, index + 1, subset, result);
            subset.remove(subset.size() - 1);
            dfs(nums, index + 1, subset, result);
        }
    }
}
