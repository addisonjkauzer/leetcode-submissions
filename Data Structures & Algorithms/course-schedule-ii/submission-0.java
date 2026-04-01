class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> coursesToPrerecs = new HashMap<>();

        for (int[] prerec : prerequisites) {
            Set<Integer> newPrerecs = coursesToPrerecs.getOrDefault(prerec[0], new HashSet<>());
            newPrerecs.add(prerec[1]);
            coursesToPrerecs.put(prerec[0], newPrerecs);
        }
        List<Integer> coursesTaken = new ArrayList<>();
        Set<Integer> allTakenCourses = new HashSet<>();
        for (Integer key : coursesToPrerecs.keySet()) {
            if (hasCycle(coursesToPrerecs, key, new HashSet(), coursesTaken, allTakenCourses)) {
                return new int[0];
            }
        }
        for (Integer i = 0; i < numCourses; i++) {
            if (!allTakenCourses.contains(i)) {
                coursesTaken.add(i);
                allTakenCourses.add(i);
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < coursesTaken.size(); i++) {
            result[i] = coursesTaken.get(i);
        }
        return result;
    }

    public boolean hasCycle(HashMap<Integer, Set<Integer>> map, Integer key, HashSet<Integer> seen, List<Integer> coursesTaken, Set<Integer> allTakenCourses) {
        if (seen.contains(key)) {
            return true;
        }
        Set<Integer> prerecs = map.getOrDefault(key, new HashSet<>());
        boolean hasCycle = false;
        seen.add(key);
        for (Integer prerec : prerecs) {
            hasCycle = hasCycle || hasCycle(map, prerec, seen, coursesTaken, allTakenCourses);
        }
        seen.remove(key);
        if (!allTakenCourses.contains(key)) {
            coursesTaken.add(key);
            allTakenCourses.add(key);
        }
        return hasCycle;
    }

}
