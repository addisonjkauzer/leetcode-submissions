class Solution {
    public int missingNumber(int[] nums) {
        int[] uniqueFinder = new int[nums.length * 2 + 1];
        int numsCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            uniqueFinder[i] = nums[i];
        }
        for (int i = nums.length; i < nums.length * 2 + 1; i++) {
            uniqueFinder[i] = i - nums.length;
        }
        System.out.println(Arrays.toString(uniqueFinder));
        Integer result = 0;
        for (int num : uniqueFinder) {
            result = result ^ num;
        }
        return result;
    }
}
