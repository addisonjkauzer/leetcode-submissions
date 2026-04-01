class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Integer leftIndex = 0;
        Integer rightIndex = numbers.length - 1;
        while (numbers[leftIndex] + numbers[rightIndex] != target) {
            Integer sum = numbers[leftIndex] + numbers[rightIndex];
            if (sum > target) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return new int[]{leftIndex + 1, rightIndex + 1};
    }
}
