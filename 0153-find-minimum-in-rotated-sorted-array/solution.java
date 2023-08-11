class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int index = nums.length / 2;
        int movement = nums.length / 4;
        int currentNumber = nums[index];
        int leftNumber = nums[index-1];

        if(nums[nums.length -1] > nums[0]) {
            return nums[0];
        }

        while (leftNumber < currentNumber) {
            index = index - movement;
            movement = movement / 2;
            if (movement == 0) {
                movement = 1;
            }
            if (index < 1) {
                index = nums.length - 1 + index;
            }
            currentNumber = nums[index];
            leftNumber = nums[index-1];
        }
        return currentNumber;
    }
}