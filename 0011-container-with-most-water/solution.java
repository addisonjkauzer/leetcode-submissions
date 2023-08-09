class Solution {
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length -1;
        int leftHeight = height[leftIndex];
        int rightHeight = height[rightIndex];
        int maxArea = 0;

        while (leftIndex < rightIndex) {
            int width = rightIndex - leftIndex;
            int currentBoxHeight = Math.min(leftHeight, rightHeight);
            int area = width * currentBoxHeight;
            if(area > maxArea) {
                maxArea = area;
            }
            if(leftHeight > rightHeight) {
                rightIndex--;
                rightHeight = height[rightIndex];
            } else {
                leftIndex++;
                leftHeight = height[leftIndex];
            }
        }
        return maxArea;
        
    }
}