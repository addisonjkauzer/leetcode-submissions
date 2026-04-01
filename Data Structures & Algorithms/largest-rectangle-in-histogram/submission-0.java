class Solution {
    public int largestRectangleArea(int[] heights) {
        final Stack<Integer[]> previousHeightsOptions = new Stack<>();
        Integer maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            final Integer height = heights[i];
            Integer previousIndex = i;
            while (!previousHeightsOptions.isEmpty() && height < previousHeightsOptions.peek()[0]) {
                final Integer[] previous = previousHeightsOptions.pop();
                final Integer previousHeight = previous[0];
                previousIndex = previous[1];
                Integer area = (i - previousIndex) * previousHeight;
                maxArea = Math.max(area, maxArea);
            }
            previousHeightsOptions.push(new Integer[] {height, previousIndex});
        }

        while (!previousHeightsOptions.isEmpty()) {
            final Integer[] previous = previousHeightsOptions.pop();
            final Integer previousHeight = previous[0];
            final Integer previousIndex = previous[1];
            final Integer area = (heights.length - previousIndex) * previousHeight;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
