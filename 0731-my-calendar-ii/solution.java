class MyCalendarTwo {

    List<Integer[]> events;

    List<Integer[]> overlaps;

    public MyCalendarTwo() {
        events = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for (Integer[] overlap : overlaps) {
            int overlapStart = overlap[0];
            int overlapEnd = overlap[1];
            if (overlapEnd > startTime && endTime > overlapStart) {
                return false;
            }
        }
        for (Integer[] event : events) {
            int eventStart = event[0];
            int eventEnd = event[1];
            if (!(endTime <= eventStart || eventEnd <= startTime)) {
                overlaps.add(new Integer[]{Math.max(eventStart, startTime), Math.min(eventEnd, endTime)});
            }
        }
        events.add(new Integer[]{startTime, endTime});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */