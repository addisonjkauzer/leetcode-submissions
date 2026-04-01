class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final Stack<Integer[]> temperatureStack = new Stack<>();
        int[] daysTillWarmer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            final Integer temperature = temperatures[i];
            while (temperatureStack.size() > 0 && temperature > temperatureStack.peek()[0]) {
                Integer[] tempIndexPair = temperatureStack.pop();
                daysTillWarmer[tempIndexPair[1]] = i - tempIndexPair[1];
            } 
            temperatureStack.push(new Integer[] {temperature, i});
        }
        return daysTillWarmer;
    }
}
