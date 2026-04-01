class Solution {
    public int maxProduct(int[] nums) {
        Integer maxProduct = nums[0];
        Integer currentMax = 1;
        Integer currentMin = 1;
        for (int num : nums) {
            Integer temp = num * currentMax;
            currentMax = Math.max(Math.max(num * currentMax, num * currentMin), num);
            currentMin = Math.min(Math.min(temp, num * currentMin), num);
            maxProduct = Math.max(currentMax, maxProduct);
        }
        return maxProduct;
    }
}
