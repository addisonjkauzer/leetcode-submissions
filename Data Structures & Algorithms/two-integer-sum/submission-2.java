class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 1;
        while (i < nums.length - 1) {
            int firstNumber = nums[i];
            int secondNumber = nums[j];
            if (firstNumber + secondNumber == target) {
                int[] returned = {i, j};
                return returned;
            }
            if (j < nums.length -  1) {
                j++;
            } else {
                i++;
                j = i + 1;
            }
        }
        throw new RuntimeException("No result found");
    }
}
