class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        return dfsMaxSumTriplet(x, y, 0, new HashSet<>(), new ArrayList<>());
    }

    public int dfsMaxSumTriplet(int[] x, int[] y, int index, HashSet<Integer> chosenX, List<Integer> chosenY) {
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
            maxSum = Math.max(maxSum, dfsMaxSumTriplet(x, y, index + 1, chosenX, chosenY));
            chosenX.remove(x[index]);
            chosenY.remove(chosenY.size() - 1);
        }
        maxSum = Math.max(maxSum, dfsMaxSumTriplet(x, y, index + 1, chosenX, chosenY));
        return maxSum;

    }
}