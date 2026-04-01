class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> runningSum = new ArrayList<>();

        dfs(candidates, 0, target, runningSum, result);
        return new ArrayList(result);
    }

    public void dfs(int[] candidates, int index, int target, List<Integer> runningSum, Set<List<Integer>> result) {
        if (target == 0) {
            List<Integer> newResult = new ArrayList(runningSum);
            Collections.sort(newResult);
            result.add(newResult);
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        runningSum.add(candidates[index]);
        dfs(candidates, index + 1, target - candidates[index], runningSum, result);
        runningSum.remove(runningSum.size() - 1);
        dfs(candidates, index + 1, target, runningSum, result);
    }
}
