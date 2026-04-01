class Solution {
    public int maxArea(int[] heights) {
        Integer leftIndex = 0;
        Integer rightIndex = heights.length - 1;
        Integer maxArea = 0;

        while (leftIndex < rightIndex) {
            final Integer leftHeight = heights[leftIndex];
            final Integer rightHeight = heights[rightIndex];
            final Integer area = Math.min(leftHeight, rightHeight) * (rightIndex - leftIndex);
            maxArea = Math.max(area, maxArea);
            if (leftHeight < rightHeight) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxArea;
        
    }
}
