class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        HashMap<Integer, Set<Integer[]>> weightedManagerToSubords = new HashMap<>();

        int head = -1;

        for (int employee = 0; employee < n; employee++) {
            int managerid = manager[employee];
            if (managerid != -1) {
                weightedManagerToSubords.computeIfAbsent(managerid, a -> new HashSet<>()).add(new Integer[]{employee, informTime[managerid]});
            } else {
                head = employee;
            }
        }

        return dfsNumMinutes(weightedManagerToSubords, head);
    }

    public int dfsNumMinutes(HashMap<Integer, Set<Integer[]>> weightedMap, int node) {

        Set<Integer[]> directs = weightedMap.getOrDefault(node, new HashSet<>());

        int max = 0;

        for (Integer[] direct : directs) {
            max = Math.max(max, direct[1] + dfsNumMinutes(weightedMap, direct[0]));
        }
        return max;
    }
}