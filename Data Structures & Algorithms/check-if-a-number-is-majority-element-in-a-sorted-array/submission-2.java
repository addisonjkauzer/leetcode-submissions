class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        Integer leftIndex = getLowerBound(nums, target);
        Integer rightIndex = getUpperBound(nums, target);
        return rightIndex - leftIndex > nums.length / 2;
    }

    public Integer getLowerBound(int[] nums, int target) {
        Integer left = 0;
        Integer right = nums.length - 1;
        Integer index = nums.length;

        while (left <= right) {
            Integer middle = (left + right) / 2;
            if (target <= nums[middle]) {
                right = middle - 1;
                index = middle;
            } else {
                left = middle + 1;
            }
        }
        return index;
    }

    public Integer getUpperBound(int[] nums, int target) {
        Integer left = 0;
        Integer right = nums.length - 1;
        Integer index = nums.length;

        while (left <= right) {
            Integer middle = (left + right) / 2;
            if (target < nums[middle]) {
                right = middle - 1;
                index = middle;
            } else {
                left = middle + 1;
            }
        }
        return index;
    }
}
