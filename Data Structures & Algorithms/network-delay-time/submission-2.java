class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, Set<Integer[]>> edgeMap = new HashMap<>();
        HashMap<Integer, Integer> nodeToDistance = new HashMap<>();

        for (int[] time : times) {
            Set<Integer[]> edges = edgeMap.getOrDefault(time[0], new HashSet<>());
            edges.add(new Integer[]{time[1], time[2]});
            edgeMap.put(time[0], edges);
        }

        for (int i = 1; i <= n; i++) {
            nodeToDistance.put(i, Integer.MAX_VALUE);
        }

        PriorityQueue<Integer[]> nodeQueue = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        nodeQueue.offer(new Integer[]{k, 0});
        nodeToDistance.put(k, 0);
        while (!nodeQueue.isEmpty()) {
            Integer currentNode = nodeQueue.remove()[0];
            Set<Integer[]> neighbors = edgeMap.getOrDefault(currentNode, new HashSet<>());
            for (Integer[] neighbor : neighbors) {
                Integer walkFromCurrent = nodeToDistance.get(currentNode) + neighbor[1];
                Integer existingDistance = nodeToDistance.get(neighbor[0]);
                if (existingDistance > walkFromCurrent) {
                    nodeToDistance.put(neighbor[0], walkFromCurrent);
                    nodeQueue.offer(new Integer[]{neighbor[0], walkFromCurrent});
                }
            }
        }
        Integer result = Collections.max(nodeToDistance.values());
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
