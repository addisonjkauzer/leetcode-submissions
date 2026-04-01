class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
        }
        Integer totalGas = Arrays.stream(diff).sum();
        if (totalGas >= 0) {
            return (minimumConsectutiveSequence(diff) + 1) % gas.length;
        }
        return -1;
    }

    public int minimumConsectutiveSequence(int[] nums) {
        Integer minSum = nums[0];
        Integer runningSum = 0;
        Integer endIndex = 0;

        for (int i=0; i < nums.length; i++) {
            runningSum = Math.min(runningSum + nums[i], nums[i]);
            if (runningSum < minSum) {
                minSum = runningSum;
                endIndex = i;
            }
        }
        return endIndex;


    }
}
