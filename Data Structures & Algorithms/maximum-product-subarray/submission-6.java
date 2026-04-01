class Solution {
    public int maxProduct(int[] nums) {
        Integer maxProduct = nums[0];
        Integer currentMax = 1;
        Integer currentMin = 1;
        for (int num : nums) {
            Integer newMax = num * currentMax;
            Integer newMin = num * currentMin;
            currentMax = Math.max(Math.max(newMax, newMin), num);
            currentMin = Math.min(Math.min(newMax, newMin), num);
            maxProduct = Math.max(currentMax, maxProduct);
        }
        return maxProduct;
    }
}
