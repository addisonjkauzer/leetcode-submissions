class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        final Deque<Integer> decreasingDeque = new ArrayDeque<>();
        decreasingDeque.addLast(nums[0]);

        int[] res = new int[nums.length - k + 1];

        Integer leftPointer = 0;
        Integer rightPointer = 1;

        while (rightPointer < k) {
            final Integer currentNumber = nums[rightPointer];
            while (!decreasingDeque.isEmpty() && currentNumber > decreasingDeque.peekLast()) {
                decreasingDeque.removeLast();
            }
            decreasingDeque.addLast(currentNumber);
            rightPointer++;
        }
        res[0] = decreasingDeque.peekFirst();

        while (rightPointer < nums.length) {

            //Update rightPointer
            final Integer rightNumber = nums[rightPointer];
            while (!decreasingDeque.isEmpty() && rightNumber > decreasingDeque.peekLast()) {
                decreasingDeque.removeLast();
            }
            decreasingDeque.addLast(rightNumber);
            rightPointer++;

            //Update leftPointer
            final Integer leftNumber = nums[leftPointer];
            if (!decreasingDeque.isEmpty() && decreasingDeque.peekFirst() == leftNumber) {
                decreasingDeque.removeFirst();
            }
            leftPointer++;
            
            //Updates res
            res[leftPointer] = decreasingDeque.peekFirst();
        }

        return res;
    }
}
