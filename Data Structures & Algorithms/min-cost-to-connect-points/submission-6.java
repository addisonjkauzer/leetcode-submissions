class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer, Set<Integer[]>> edgeMap = new HashMap();

        for (int i = 0; i < points.length; i++) {
            int[] point1 = points[i];
            Set<Integer[]> neighbors = edgeMap.getOrDefault(i, new HashSet<>());
            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                Integer distance = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
                edgeMap.computeIfAbsent(i, k -> new HashSet<>()).add(new Integer[]{j, distance});
                edgeMap.computeIfAbsent(j, k -> new HashSet<>()).add(new Integer[]{i, distance});
            }
        }
        
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        HashSet<Integer> visited = new HashSet<>();
        Integer totalDistance = 0;
        
        minHeap.offer(new Integer[] {0, 0});


        while (visited.size() < points.length) {
            Integer[] indexAndDistance = minHeap.poll();
            Integer nodeIndex = indexAndDistance[0];
            Integer distance = indexAndDistance[1];
            if (visited.contains(nodeIndex)) {
                continue;
            }
            visited.add(nodeIndex);
            totalDistance+= distance;
            Set<Integer[]> neighbors = edgeMap.getOrDefault(nodeIndex, new HashSet<>());
            for (Integer[] neighbor : neighbors) {
                if (!visited.contains(neighbor[0])) {
                    minHeap.offer(neighbor);
                }
            }
        }
        return totalDistance;
    }
}
