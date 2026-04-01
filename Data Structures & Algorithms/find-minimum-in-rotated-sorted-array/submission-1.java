class Solution {
    public int findMin(int[] nums) {
        Integer leftPointer = 0;
        Integer rightPointer = nums.length  - 1;

        while (leftPointer <= rightPointer) {
            if (rightPointer - leftPointer <= 1) {
                return Math.min(nums[leftPointer], nums[rightPointer]);
            }
            final Integer middlePointer = leftPointer + (rightPointer - leftPointer) / 2;
            final Integer middleNumber = nums[middlePointer];
            if (nums[leftPointer] < nums[rightPointer]) {
                return nums[leftPointer];
            }
            if (middleNumber >= nums[rightPointer]) {
                leftPointer = middlePointer;
            } else {
                rightPointer = middlePointer;
            }
        }
        return Math.min(nums[leftPointer], nums[rightPointer]);
        
    }
}
