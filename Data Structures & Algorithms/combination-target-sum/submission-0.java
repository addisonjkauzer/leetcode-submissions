class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> runningSumNumbers = new ArrayList<>();

        dfs(nums, 0, target, runningSumNumbers, result);
        return new ArrayList(result);
    }

    public void dfs(int[] nums, 
    Integer index, 
    int target, 
    List<Integer> runningSumNumbers, 
    Set<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(runningSumNumbers));
            return;
        } else if(target < 0 || index >= nums.length) {
            return;
        } else {
            //Take current number and don't increment Index
            runningSumNumbers.add(nums[index]);
            System.out.println(runningSumNumbers);
            dfs(nums, index, target - nums[index], runningSumNumbers, result);

            //Take current Number and increment Index
            dfs(nums, index + 1, target - nums[index], runningSumNumbers, result);

            //Don't take current number and increment Index
            runningSumNumbers.remove(runningSumNumbers.size() - 1);
            dfs(nums, index + 1, target, runningSumNumbers, result);
        }
    }
}
