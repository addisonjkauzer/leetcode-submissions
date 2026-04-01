class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, Set<Integer>> edgeMap = new HashMap<>();

        for (int[] edge : edges) {
            Set<Integer> children = edgeMap.getOrDefault(edge[0], new HashSet<>());
            children.add(edge[1]);
            edgeMap.put(edge[0], children);

            children = edgeMap.getOrDefault(edge[1], new HashSet<>());
            children.add(edge[0]);
            edgeMap.put(edge[1], children);
        }
        Set<List<Integer>> allRemoveable = new HashSet<>();
        for (Integer key : edgeMap.keySet()) {
            Set<List<Integer>> removeable = new HashSet<>();
            dfs(edgeMap, key, new HashSet<>(), removeable, -1);
            allRemoveable.addAll(removeable);
        }
        System.out.println(allRemoveable);
        for (int i = edges.length - 1; i >= 0; i--) {
            List<Integer> edge1 = Arrays.asList(edges[i][0], edges[i][1]);
            List<Integer> edge2 = Arrays.asList(edges[i][1], edges[i][0]);
            if (allRemoveable.contains(edge1) || allRemoveable.contains(edge2)) {
                return edges[i];
            }
        }
        return null;
    }


    public void dfs(HashMap<Integer, Set<Integer>> edgeMap, Integer key, Set<Integer> visited, Set<List<Integer>> removeable, Integer parent) {
        if (visited.contains(key)) {
            removeable.add(Arrays.asList(key, parent));
            return;
        }
        Set<Integer> edges = edgeMap.getOrDefault(key, new HashSet<>());

        visited.add(key);
        for (Integer edge : edges) {
            if (edge == parent) {
                continue;
            }
            dfs(edgeMap, edge, visited, removeable, key);
        }
        visited.remove(key);
    }
}
