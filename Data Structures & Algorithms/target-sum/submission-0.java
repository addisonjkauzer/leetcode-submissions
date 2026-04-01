class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfsTargetSum(nums, 0, target, new HashMap<>());
        
    }

    public int dfsTargetSum(final int[] nums, final Integer index, final Integer target, final HashMap<List<Integer>, Integer> cache) {
        if (cache.containsKey(Arrays.asList(index, target))) {
            return cache.get(Arrays.asList(index, target));
        }
        if (target == 0 && index == nums.length) {
            return 1;
        }
        if (index >= nums.length) {
            return 0;
        }
        final Integer addNumber = dfsTargetSum(nums, index+1, target - nums[index], cache);
        final Integer subtractNumber = dfsTargetSum(nums, index+1, target + nums[index], cache);
        cache.put(Arrays.asList(index, target), addNumber + subtractNumber);
        return addNumber + subtractNumber;
    }
}
