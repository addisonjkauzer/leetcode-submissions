class Solution {
    public double averageWaitingTime(int[][] customers) {

        List<Integer> waitTimes = new ArrayList<>();

        int nextAvailableTime = 0;

        for (int[] customer : customers) {
            int arrival = customer[0];
            int time = customer[1];
            if (arrival >= nextAvailableTime) {
                waitTimes.add(time);
                nextAvailableTime = arrival + time;
            } else {
                int timeTillAvailable = nextAvailableTime - arrival;
                waitTimes.add(time + timeTillAvailable);
                nextAvailableTime = arrival + time + timeTillAvailable;
            }
        }
        return waitTimes.stream().mapToDouble(a -> a).sum() / waitTimes.size();
    }
}