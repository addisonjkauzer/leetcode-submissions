class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, Set<Integer[]>> edgeMap = new HashMap<>();
        for (int[] time : times) {
            edgeMap.computeIfAbsent(time[0], a -> new HashSet<>()).add(new Integer[]{time[1], time[2]});
        }

        PriorityQueue<Integer[]> openEdges = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        openEdges.addAll(edgeMap.getOrDefault(k, new HashSet<>()));
        HashSet<Integer> visited = new HashSet<>();
        visited.add(k);
        int maxCost = 0;

        while(!openEdges.isEmpty()) {
            Integer[] newEdge = openEdges.poll();
            Integer newNode = newEdge[0];
            Integer cost = newEdge[1];
            if (visited.contains(newNode)) {
                continue;
            }
            visited.add(newNode);
            maxCost = Math.max(maxCost, cost);
            System.out.println(visited);
            if (visited.size() == n) {
                return maxCost;
            }
            Set<Integer[]> newEdges = edgeMap.getOrDefault(newNode, new HashSet<>());
            for (Integer[] e : newEdges) {
                openEdges.add(new Integer[]{e[0], e[1] + cost});
            }
        }
        if (visited.size() == n) {
            return maxCost;
        } else {
            return -1;
        }
    }
}
