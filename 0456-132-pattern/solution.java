class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer[]> stack = new Stack<>();

        int minLeft = nums[0];

        for (int i = 1; i< nums.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek()[0] < nums[i]) {
                return true;
            }
            stack.push(new Integer[]{minLeft, nums[i]});
            minLeft = Math.min(minLeft, nums[i]);
        }
        return false;
    }
}