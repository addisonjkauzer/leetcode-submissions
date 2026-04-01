class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        List<Integer> runningPermutation = new ArrayList<>();

        dfs(nums, runningPermutation, results);

        return new ArrayList(results);
    }

    public void dfs(int[] nums, List<Integer> runningPermutation, Set<List<Integer>> results) {
        if (runningPermutation.size() == nums.length) {
            results.add(new ArrayList(runningPermutation));
        }
        for (int num : nums) {
            if (!runningPermutation.contains(num)) {
                runningPermutation.add(num);
                dfs(nums, runningPermutation, results);
                runningPermutation.remove(runningPermutation.size() - 1);
            }
        }
    }
}
