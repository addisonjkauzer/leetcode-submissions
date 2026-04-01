class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        Integer minLength = Integer.MAX_VALUE;
        Integer leftPointer = 0;
        Integer rightPointer = 0;
        Integer currentSum = 0;
        while (rightPointer < nums.length) {
            if (currentSum < target) {
                currentSum += nums[rightPointer];
                rightPointer++;
            } else {
                Integer currentLength = rightPointer - leftPointer;
                minLength = Math.min(currentLength, minLength);
                currentSum -= nums[leftPointer];
                leftPointer++;
            }
        }
        while (currentSum >= target) {
                Integer currentLength = rightPointer - leftPointer;
                minLength = Math.min(currentLength, minLength);
                currentSum -= nums[leftPointer];
                leftPointer++;
        }

        if (minLength == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLength;
        }
    }
}