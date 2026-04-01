class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productExceptSelf = new int[nums.length];
        int runningMultiplication = 1;
        for (int i = 0; i < nums.length; i++) {
            productExceptSelf[i] = runningMultiplication;
            runningMultiplication *= nums[i];
        }

        runningMultiplication = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            productExceptSelf[i] *= runningMultiplication;
            runningMultiplication *= nums[i];
        }

        return productExceptSelf;
    }
}  
