class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        Integer left = 0;
        Integer right = nums.length - 1;
        Integer index = nums.length;
        while (left <= right) {
            Integer middle = (right + left) / 2;
            if (target < nums[middle]) {
                right = middle - 1;
                index = middle;
            } else if (target > nums[middle]) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return index;
    }
}