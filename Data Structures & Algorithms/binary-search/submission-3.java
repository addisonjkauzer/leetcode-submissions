class Solution {
    public int search(int[] nums, int target) {
        Integer leftPointer = 0;
        Integer rightPointer = nums.length -1;

        while (leftPointer <= rightPointer) {

            final Integer middleIndex = leftPointer + ((rightPointer - leftPointer) /2);
            final Integer middleNumber = nums[middleIndex];

            if (target > middleNumber) {
                leftPointer = middleIndex + 1;
            } else if (target < middleNumber) {
                rightPointer = middleIndex - 1;
            } else {
                return middleIndex;
            }
        }
        return -1;
    }
}
