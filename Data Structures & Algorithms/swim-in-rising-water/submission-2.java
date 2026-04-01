class Solution {
    public int swimInWater(int[][] grid) {
        Integer[][] DIRECTIONS = new Integer[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        HashMap<List<Integer>, Set<Integer[]>> edgeMap = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid.length; j++) {
                Integer currentValue = grid[i][j];
                for (Integer[] direction : DIRECTIONS) {
                    Integer newI = i + direction[0];
                    Integer newJ = j + direction[1];
                    if (newI < grid.length && newI >=0 && newJ < grid[0].length && newJ >=0) {
                        Integer distance = grid[newI][newJ];
                        edgeMap.computeIfAbsent(Arrays.asList(i, j), k -> new HashSet<>()).add(new Integer[]{newI, newJ, distance});
                    }
                }
            }
        }

        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(Comparator.comparing(k -> k[2]));
        HashSet<List<Integer>> visited = new HashSet<>();
        minHeap.offer(new Integer[]{0, 0, grid[0][0]});

        while (!minHeap.isEmpty()) {
            Integer[] currentNode = minHeap.poll();
            List<Integer> currentNodeAsList = Arrays.asList(currentNode[0], currentNode[1]);
            visited.add(currentNodeAsList);
            Set<Integer[]> neighbors = edgeMap.getOrDefault(currentNodeAsList, new HashSet<>());
            for (Integer[] neighbor : neighbors) {
                if (!visited.contains(Arrays.asList(neighbor[0], neighbor[1]))) {
                    Integer neighborDistance = Math.max(currentNode[2], neighbor[2]);
                    if (neighbor[0] == grid.length - 1 && neighbor[1] == grid[0].length - 1) {
                        return neighborDistance;
                    }
                    minHeap.offer(new Integer[]{neighbor[0], neighbor[1], neighborDistance});
                }
            }
        }
        return -1;
        
    }
}
