class CountSquares {

    HashMap<List<Integer>, Integer> ptsCount;
    List<List<Integer>> points;

    public CountSquares() {
        ptsCount = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        List<Integer> p = Arrays.asList(point[0], point[1]);
        ptsCount.put(p, ptsCount.getOrDefault(p, 0) + 1);
        points.add(p);
    }
    
    public int count(int[] point) {
        Integer count = 0;

        for (List<Integer> existingPoint : points) {
            if (Math.abs(point[0] - existingPoint.get(0)) != Math.abs(point[1] - existingPoint.get(1)) || point[0] == existingPoint.get(0) || point[1] == existingPoint.get(1)) {
                continue;
            }

            count += ptsCount.getOrDefault(Arrays.asList(point[0], existingPoint.get(1)), 0) * ptsCount.getOrDefault(Arrays.asList(existingPoint.get(0), point[1]), 0);
        }

        return count;
    }
}
