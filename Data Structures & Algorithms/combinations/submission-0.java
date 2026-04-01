class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(1, n, k, new ArrayList<>(), result);
        return result;
    }

    public void combine(int runningN, int maxN, int k, List<Integer> runningList, List<List<Integer>> result) {
        if (runningList.size() == k) {
            result.add(new ArrayList(runningList));
            return;
        }
        if (runningN > maxN) {
            return;
        }
        runningList.add(runningN);
        combine(runningN + 1, maxN, k, runningList, result);
        runningList.remove(runningList.size() - 1);
        combine(runningN + 1, maxN, k, runningList, result);
    }
}