class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> edgeMap = new HashMap<>();
        for (int[] prereq : prerequisites) {
            edgeMap.computeIfAbsent(prereq[0], a -> new HashSet<>()).add(prereq[1]);
        }

        HashSet<Integer> allVisited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (dfsHasCycle(i, edgeMap, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    public boolean dfsHasCycle(int course, 
    HashMap<Integer, Set<Integer>> edgeMap, 
    HashSet<Integer> visited) {
        if (visited.contains(course)) {
            return true;
        }
        visited.add(course);
        boolean hasCycle = false;
        for (Integer newNode : edgeMap.getOrDefault(course, new HashSet<>())) {
            hasCycle |= dfsHasCycle(newNode, edgeMap, visited);
        }
        visited.remove(course);
        edgeMap.put(course, new HashSet<>());
        return hasCycle;
    }
}
