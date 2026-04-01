class Solution {
    public int jump(int[] nums) {
        int startOfWindow = 0;
        int endOfWindow = 0;
        int newEndOfWindow = 0;
        int result = 0;
        while (endOfWindow < nums.length - 1) {
            while(startOfWindow <= endOfWindow) {
                newEndOfWindow = Math.max(newEndOfWindow, nums[startOfWindow] + startOfWindow);
                startOfWindow++;
            }
            endOfWindow = newEndOfWindow;
            result++;
        }
        return result;
    }
}
