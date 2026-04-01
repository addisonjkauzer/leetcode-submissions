class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final HashMap<Integer, Set<Integer[]>> edgeMap = new HashMap<>();

        for (int[] flight : flights) {
            edgeMap.computeIfAbsent(flight[0], a -> new HashSet<>()).add(new Integer[]{flight[1], flight[2]});
        }

        final PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        minHeap.add(new Integer[]{src, 0, 0});

        while(!minHeap.isEmpty()) {
            final Integer[] currentNode = minHeap.poll();
            final Integer currentAirport = currentNode[0];
            final Integer costSoFar = currentNode[1];
            final Integer stopsSoFar = currentNode[2];

            if (currentAirport == dst) {
                return costSoFar;
            }

            Set<Integer[]> neighbors = edgeMap.getOrDefault(currentAirport, new HashSet<>());

            for (Integer[] neighbor : neighbors) {
                final Integer newAirport = neighbor[0];
                final Integer newCost = costSoFar + neighbor[1];
                final Integer newStops = stopsSoFar + 1;
                if (newStops <= k + 1) {
                    minHeap.offer(new Integer[]{newAirport, newCost, newStops});
                }
            }
        }
        return -1;
    }
}
