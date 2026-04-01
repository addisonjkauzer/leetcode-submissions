class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        final Stack<Double> carFleetsTTD = new Stack<>();
        final List<Integer[]> sortedPositionsAndSpeeds = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            sortedPositionsAndSpeeds.add(new Integer[]{position[i], speed[i]});
        }

        sortedPositionsAndSpeeds.sort(Comparator.comparing(a -> a[0]));


        for (final Integer[] positionAndSpeed : sortedPositionsAndSpeeds) {
            final Integer currentPosition = positionAndSpeed[0];
            final Integer currentSpeed = positionAndSpeed[1];
            final Double timeToDestination = (target-currentPosition)/(double)currentSpeed;
            System.out.println(timeToDestination);
            System.out.println(carFleetsTTD);
            while (!carFleetsTTD.isEmpty() && carFleetsTTD.peek() <= timeToDestination) {
                carFleetsTTD.pop();
            }
            carFleetsTTD.push(timeToDestination);
        }
        return carFleetsTTD.size();
        
    }
}
