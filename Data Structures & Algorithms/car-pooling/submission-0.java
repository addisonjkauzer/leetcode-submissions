class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparing(a -> a[1]));

        int currentPeople = 0;

        PriorityQueue<Integer[]> dropOffs = new PriorityQueue<>(Comparator.comparing(a -> a[1]));

        for (int[] trip : trips) {
            int numPeople = trip[0];
            int startLocation = trip[1];
            int endLocation = trip[2];
            while (!dropOffs.isEmpty() && dropOffs.peek()[1] <= startLocation) {
                currentPeople -= dropOffs.poll()[0];
            }
            currentPeople += numPeople;
            dropOffs.offer(new Integer[]{numPeople, endLocation});
            if (currentPeople > capacity) {
                return false;
            }
        }
        return true;
        
    }
}