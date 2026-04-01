class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> coursesToPrerecs = new HashMap<>();

        for (int[] prerec : prerequisites) {
            Set<Integer> newPrerecs = coursesToPrerecs.getOrDefault(prerec[0], new HashSet<>());
            newPrerecs.add(prerec[1]);
            coursesToPrerecs.put(prerec[0], newPrerecs);
        }

        for (Integer key : coursesToPrerecs.keySet()) {
            if (hasCycle(coursesToPrerecs, key, new HashSet())) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCycle(HashMap<Integer, Set<Integer>> map, Integer key, HashSet<Integer> seen) {
        if (seen.contains(key)) {
            return true;
        }
        Set<Integer> prerecs = map.getOrDefault(key, new HashSet<>());
        boolean hasCycle = false;
        seen.add(key);
        for (Integer prerec : prerecs) {
            hasCycle = hasCycle || hasCycle(map, prerec, seen);
        }
        seen.remove(key);
        return hasCycle;
    }

}
