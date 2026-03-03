class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] result = new int[nums.length / 3][3];
        int resultIndex = 0;

        for (int i = 0; i < nums.length; i = i + 3) {
            int first = nums[i];
            int second = nums[i + 1];
            int third = nums[i + 2];
            if (third - first <= k) {
                result[resultIndex] = new int[]{first, second, third};
            } else {
                return new int[0][0];
            }
            resultIndex++;
        }
        return result;
        
    }
}