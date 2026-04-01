class Solution {
    public int maxCoins(int[] nums) {
        LinkedList<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedList::new));
        return maxCoinsDp(numsList, new HashMap<>());
    }

    public int maxCoinsDp(LinkedList<Integer> nums, Map<LinkedList<Integer>, Integer> cache) {
        if (cache.containsKey(nums)) {
            return cache.get(nums);
        }
        if (nums.size() == 0) {
            return 0;
        }
        Integer maxCoins = 0;
        for (int i = 0; i < nums.size(); i++) {
            Integer coinAtIndex = nums.get(i);
            Integer coinLeftOfIndex = i - 1 >= 0 ? nums.get(i-1) : 1;
            Integer coinRightOfIndex = i + 1 < nums.size() ? nums.get(i+1) : 1;
            nums.remove(i);
            Integer coins = coinAtIndex * coinLeftOfIndex * coinRightOfIndex + maxCoinsDp(nums, cache);
            maxCoins = Math.max(maxCoins, coins);
            nums.add(i, coinAtIndex);
        }
        cache.put(nums, maxCoins);
        return maxCoins;
    }
}
