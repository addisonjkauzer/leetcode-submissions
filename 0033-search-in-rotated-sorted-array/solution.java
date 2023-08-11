class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            }
            return -1;
        }
        if(nums.length == 2) {
            if (nums[0] == target) {
                return 0;
            }
            if (nums[1] == target) {
                return 1;
            }
            return -1;
        }
        int index = nums.length / 2;
        int movement = nums.length / 4;

        while (nums[index] != target) {
            if (movement == 0) {
                movement = 1;
            }
            int leftNumber;
            int rightNumber;
            if (index-1 < 0) {
                int leftIndex = nums.length - 1 + index;
                leftNumber = nums[leftIndex];
            } else {
                leftNumber = nums[index-1];
            }

            if (index + 1 > nums.length -1) {
                int rightIndex =  index + 1 - nums.length;
                rightNumber = nums[rightIndex];
            } else {
                rightNumber = nums[index+1];
            }


            if (target > nums[index]) {
                if (target < rightNumber) {
                    return -1;
                }
                if (rightNumber < nums[index]) {
                    return -1;
                }
                index = index + movement;
            } else {
                if (target > leftNumber) {
                    return -1;
                }
                if (leftNumber > nums[index]) {
                    return -1;
                }
                index = index - movement;
            }
            movement = movement / 2;

            if (index < 0) {
                index = nums.length + index;
            }
            if (index > nums.length -1) {
                index =  index - nums.length;
            }
        }
        return index;
    }
}