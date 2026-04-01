class Solution {
    public int trap(int[] height) {
        if (height == null && height.length <= 2) {
            return 0;
        }
        Integer totalWater = 0;
        
        final Integer[] maxLefts = new Integer[height.length];
        Integer currentMaxLeft = 0;
        for (int i = 0; i < height.length; i++) {
            maxLefts[i] = currentMaxLeft;
            currentMaxLeft = Math.max(currentMaxLeft, height[i]);
        }

        final Integer[] maxRights = new Integer[height.length];
        Integer currentMaxRight = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            maxRights[i] = currentMaxRight;
            currentMaxRight = Math.max(currentMaxRight, height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            final Integer smallestWall = Math.min(maxLefts[i], maxRights[i]);
            final Integer water = smallestWall - height[i];
            if (water >= 0) {
                totalWater += water;
            }
        }

        return totalWater;
    }
}
