class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, Set<Integer>> edgeMap = new HashMap<>();

        for (int[] edge : edges) {
            Set<Integer> children = edgeMap.getOrDefault(edge[0], new HashSet<>());
            Set<Integer> reverseChildren = edgeMap.getOrDefault(edge[1], new HashSet<>());
            children.add(edge[1]);
            reverseChildren.add(edge[0]);
            edgeMap.put(edge[0], children);
            edgeMap.put(edge[1], reverseChildren);
        }
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> allSeen = new HashSet<>();
        if (hasCycle(edgeMap, 0, seen, -1, allSeen)) {
            return false;
        }
        if (allSeen.size() == n) {
            return true;
        }
        return false;

    }

    public boolean hasCycle(HashMap<Integer, Set<Integer>> edgeMap, Integer key, Set<Integer> seen, Integer parent, Set<Integer> allSeen) {
        allSeen.add(key);
        if (seen.contains(key)) {
            return true;
        }
        Set<Integer> edges = edgeMap.getOrDefault(key, new HashSet<>());
        boolean hasCycle = false;
        seen.add(key);
        for (Integer edge : edges) {
            if (edge == parent) {
                continue;
            }
            hasCycle = hasCycle || hasCycle(edgeMap, edge, seen, key, allSeen);
        }
        seen.remove(key);
        return hasCycle;
    }
}
