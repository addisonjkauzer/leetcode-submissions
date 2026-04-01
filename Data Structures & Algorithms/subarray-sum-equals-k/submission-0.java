class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixArraySums = new HashMap<>();
        prefixArraySums.put(0,1);
        Integer sum = 0;
        Integer count = 0;
        for (int num : nums) {
            sum += num;
            Integer idealPrefix = sum - k;
            Integer prefixCount = prefixArraySums.getOrDefault(idealPrefix, 0);
            count += prefixCount;
            prefixArraySums.put(sum, prefixArraySums.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}