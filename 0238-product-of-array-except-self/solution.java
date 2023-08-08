class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i <answer.length; i++) {
            answer[i] = 1;
        }
        int runningMulitplication = 1;
        for(int i = 0; i < answer.length; i++) {
            answer[i] = answer[i] * runningMulitplication;
            runningMulitplication = runningMulitplication * nums[i];
        }

        runningMulitplication = 1;
        for(int i = answer.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * runningMulitplication;
            runningMulitplication = runningMulitplication * nums[i];
        }
        return answer;
    }
}