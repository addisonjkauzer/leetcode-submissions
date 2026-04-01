class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, Set<Integer>> edgeMap = new HashMap<>();
        for (int[] edge: edges) {
            Set<Integer> children = edgeMap.getOrDefault(edge[0], new HashSet<>());
            children.add(edge[1]);
            edgeMap.put(edge[0], children);
            Set<Integer> childrenReverse = edgeMap.getOrDefault(edge[1], new HashSet<>());
            childrenReverse.add(edge[0]);
            edgeMap.put(edge[1], childrenReverse);
        }

        Set<Integer> visited = new HashSet<>();
        Integer componentCount = 0;
        for (Integer key : edgeMap.keySet()) {
            if (!visited.contains(key)) {
                componentCount++;
                dfs(edgeMap, key, visited);
            }
        }
        Integer spareNodes = n - visited.size();
        return componentCount + spareNodes;
    }

    public void dfs(HashMap<Integer, Set<Integer>> edgeMap, Integer key, Set<Integer> visited) {
        if (visited.contains(key)) {
            return;
        }
        Set<Integer> children = edgeMap.getOrDefault(key, new HashSet<>());

        visited.add(key);
        for (Integer child : children) {
            dfs(edgeMap, child, visited);
        }
    }
}
