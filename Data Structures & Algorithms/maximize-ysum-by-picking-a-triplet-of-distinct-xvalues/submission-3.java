class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        return dfsMaxSumTriplet(x, y, 0, new ArrayList<>(), new ArrayList<>(), new HashMap<>());
    }

    public int dfsMaxSumTriplet(int[] x, int[] y, int index, List<Integer> chosenX, List<Integer> chosenY, HashMap<String, Integer> cache) {
        String key = index + "," + chosenX + "," + chosenY;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (chosenY.size() == 3) {
            return chosenY.stream().mapToInt(Integer::intValue).sum();
        }
        if (index == y.length) {
            return -1;
        }

        Integer maxSum = -1;
        //Take Value
        if (!chosenX.contains(x[index])) {
            chosenX.add(x[index]);
            chosenY.add(y[index]);
            maxSum = Math.max(maxSum, dfsMaxSumTriplet(x, y, index + 1, chosenX, chosenY, cache));
            chosenX.remove(chosenX.size() - 1);
            chosenY.remove(chosenY.size() - 1);
        }
        maxSum = Math.max(maxSum, dfsMaxSumTriplet(x, y, index + 1, chosenX, chosenY, cache));
        cache.put(key, maxSum);
        return maxSum;

    }
}