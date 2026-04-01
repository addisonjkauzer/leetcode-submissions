class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        final HashSet<List<Integer>> threeSums = new HashSet<>();

        final HashMap<Integer, Integer> numsToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsToIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                final Integer partialSum = nums[i] + nums[j];
                final Integer target = 0 - partialSum;
                if (numsToIndex.containsKey(target) && numsToIndex.get(target) > j) {
                    final Integer[] threeSum = new Integer[]{nums[i], nums[j], target};
                    Arrays.sort(threeSum);
                    final List<Integer> threeSumList = Arrays.asList(threeSum);
                    threeSums.add(threeSumList);
                }
            }
        }
        final List<List<Integer>> threeSumsList = new ArrayList<>(threeSums);
        return threeSumsList;
        
    }
}
