class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        Set<Integer> roots = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            roots.add(i);
        }

        for (int[] relation : relations) {
            Set<Integer> existing = graph.getOrDefault(relation[0], new HashSet<>());
            existing.add(relation[1]);
            graph.put(relation[0], existing);
            roots.remove(relation[1]);
        }

        Integer maxDepth = -1;
        HashMap<Integer, Integer> cache = new HashMap<>();

        for (Integer root : roots) {
            int depth = 1 + dfsGetMaxDepth(graph, new HashSet<>(), root, cache);
            if (depth == -1) return -1;
            maxDepth = Math.max(maxDepth, depth);
        }
        if (cache.size() != n) {
            return -1;
        }
        return maxDepth;
    }

    public int dfsGetMaxDepth(HashMap<Integer, Set<Integer>> graph, HashSet<Integer> seen, Integer root, HashMap<Integer, Integer> cache) {
        if (seen.contains(root)) {
            return -1;
        }
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        seen.add(root);
        Integer maxDepth = 0;
        Set<Integer> children = graph.getOrDefault(root, new HashSet<>());
        for (Integer child : children) {
            int depth = dfsGetMaxDepth(graph, seen, child, cache);
            if (depth == -1) return -1;
            maxDepth = Math.max(maxDepth, 1 + depth);
        }
        seen.remove(root);
        cache.put(root, maxDepth);
        return maxDepth;
    }
}
