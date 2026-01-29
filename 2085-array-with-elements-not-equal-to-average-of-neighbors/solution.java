class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> sortedNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(sortedNums);
        int[] result = new int[nums.length];
        Integer left = 0;
        Integer right = sortedNums.size() - 1;
        Integer i = 0;
        while (i < result.length) {
            result[i++] = sortedNums.get(left);
            if (i == result.length) {
                break;
            }
            result[i++] = sortedNums.get(right);
            left++;
            right--;
        }
        return result;
    }
}