class Solution {
    public int[] shuffle(int[] nums, int n) {
        int left = 0;
        int right = n;

        int[] result = new int[nums.length];
        int i = 0;

        while (right < nums.length) {
            result[i] = nums[left];
            i++;
            left++;
            result[i] = nums[right];
            i++;
            right++;
        }
        return result;
    }
}