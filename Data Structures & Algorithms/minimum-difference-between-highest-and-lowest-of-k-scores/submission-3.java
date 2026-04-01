class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int difference = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int num1 = nums[i];
            int num2 = nums[i + k - 1];
            difference = Math.min(difference, num2 - num1);
        }
        return difference == Integer.MAX_VALUE ? 0 : difference;
    }
}