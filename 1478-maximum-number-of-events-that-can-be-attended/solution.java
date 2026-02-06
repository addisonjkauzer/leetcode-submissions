class Solution {
    public int maxEvents(int[][] events) {
        List<int[]> sortedEvents = new ArrayList<>();

        for (int[] event : events) {
            sortedEvents.add(event);
        }
        Collections.sort(sortedEvents, Comparator.comparing(a -> a[0]));

        PriorityQueue<Integer> lastDayMinHeap = new PriorityQueue<>();
        Integer count = 0;
        Integer currentDay = 1;
        Integer sortedEventsIndex = 0;
        while (sortedEventsIndex < sortedEvents.size() || !lastDayMinHeap.isEmpty()) {

            // Add all events with first day less than or = current day
            while (sortedEventsIndex < sortedEvents.size() && sortedEvents.get(sortedEventsIndex)[0] == currentDay) {
                lastDayMinHeap.add(sortedEvents.get(sortedEventsIndex)[1]);
                sortedEventsIndex++;
            }

            // Remove all events with last day less than current day
            while (!lastDayMinHeap.isEmpty() && lastDayMinHeap.peek() < currentDay) {
                lastDayMinHeap.poll();
            }

            //If possible event use it
            if (!lastDayMinHeap.isEmpty()) {
                lastDayMinHeap.poll();
                count++;
            }

            //Increment day
            if (sortedEventsIndex < sortedEvents.size() && lastDayMinHeap.isEmpty()) {
                currentDay = sortedEvents.get(sortedEventsIndex)[0];
            } else {
                currentDay++;
            }
        }
        return count;
    }
}