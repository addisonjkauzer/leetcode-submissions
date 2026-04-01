class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int maxLength = 1;
        int operations = 0;
        int leftPointer = 0;
        int rightPointer = 1;


        while (rightPointer < nums.length) {
            int operationsNeededPerNumber = nums[rightPointer] - nums[rightPointer - 1];
            int prevLength = rightPointer - leftPointer;
            operations += prevLength * operationsNeededPerNumber;

            while (operations > k) {
                operations -= nums[rightPointer] - nums[leftPointer];
                leftPointer++;
            }

            maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
            rightPointer++;
        }

        return maxLength;
    }
}