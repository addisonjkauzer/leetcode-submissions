class Solution {
    public int findMaxLength(int[] nums) {
        Integer result = 0;
        Integer ones = 0;
        int zeros = 0;
        HashMap<Integer, Integer> diffIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                ones++;
            }

            Integer difference = ones - zeros;
            if (!diffIndex.containsKey(difference)) {
                diffIndex.put(difference, i);
            }

            if (zeros == ones) {
                result = zeros + ones;
            } else {
                result = Math.max(result, i - diffIndex.get(difference));
            }
        }
        return result;
    }
}