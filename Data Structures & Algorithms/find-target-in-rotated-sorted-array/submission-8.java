class Solution {
    public int search(int[] nums, int target) {
        Integer leftPointer = 0;
        Integer rightPointer = nums.length  - 1;

        while (leftPointer <= rightPointer) {
            final Integer middlePointer = leftPointer + (rightPointer - leftPointer) / 2;
            final Integer middleNumber = nums[middlePointer];
            final Integer leftNumber = nums[leftPointer];
            final Integer rightNumber = nums[rightPointer];
            final Boolean rightOfPivot = leftNumber <= middleNumber;

            if (target == middleNumber) {
                return middlePointer;
            }

            if (rightOfPivot) {
                if (target > middleNumber || target < leftNumber) {
                    leftPointer = middlePointer + 1;
                } else {
                    rightPointer = middlePointer - 1;
                }
            } else {
                if (target < middleNumber || target > rightNumber) {
                    rightPointer = middlePointer - 1;
                } else {
                    leftPointer = middlePointer + 1;
                }
            }
        }
        return -1;
        
    }
}
