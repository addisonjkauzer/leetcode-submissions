class Solution {
    public List<List<Integer>> getFactors(int n) {
        Set<List<Integer>> result = new HashSet<>();
        dfsGetFactors(n, new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    public void dfsGetFactors(int n, List<Integer> runningFactor, Set<List<Integer>> result) {

        if (n == 1) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(runningFactor);
            Collections.sort(copy);
            if (copy.size() > 1) {
                result.add(copy);
            }
        }

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                runningFactor.add(i);
                dfsGetFactors(n / i, runningFactor, result);
                runningFactor.removeLast();
            }
        }
    }
}
