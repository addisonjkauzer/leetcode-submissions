class Solution {
    public int maxCoins(int[] nums) {
        return maxCoinsDp(nums, 0, nums.length - 1, new HashMap<>());
    }

    public int maxCoinsDp(int[] nums, Integer leftPointer, Integer rightPointer, Map<List<Integer>, Integer> cache) {
        if (cache.containsKey(Arrays.asList(leftPointer, rightPointer))) {
            return cache.get(Arrays.asList(leftPointer, rightPointer));
        }
        if (leftPointer > rightPointer) {
            return 0;
        }
        Integer maxCoins = 0;
        for (int i = leftPointer; i <= rightPointer; i++) {
            Integer leftLimit = leftPointer - 1 >= 0 ? nums[leftPointer - 1] : 1;
            Integer rightLimit = rightPointer + 1 < nums.length ? nums[rightPointer + 1] : 1;
            Integer coins = nums[i] * leftLimit * rightLimit;
            Integer leftSequence = maxCoinsDp(nums, leftPointer, i - 1, cache);
            Integer rightSequence = maxCoinsDp(nums, i + 1, rightPointer, cache);
            maxCoins = Math.max(maxCoins, coins + leftSequence + rightSequence);
        }
        cache.put(Arrays.asList(leftPointer, rightPointer), maxCoins);
        return maxCoins;
    }
}
