class Solution {

    public int mostBooked(int n, int[][] meetings) {
        HashMap<Long, Integer> roomToNumBookings = new HashMap<>();
        PriorityQueue<Long[]> roomNumberAndOpenTime = new PriorityQueue<>((a, b) -> {
            if (a[1].equals(b[1])) {
                return Long.compare(a[0], b[0]);
            } else {
                return Long.compare(a[1], b[1]);
            }
        });
        Arrays.sort(meetings, Comparator.comparing(a -> a[0]));
        for (long i = 0; i < n; i++) {
            roomNumberAndOpenTime.offer(new Long[]{i, 0L});
        }


        for (int[] meeting : meetings) {
            List<Long> availableRooms = new ArrayList<>();
            while (!roomNumberAndOpenTime.isEmpty() && meeting[0] >= roomNumberAndOpenTime.peek()[1]) {
                availableRooms.add(roomNumberAndOpenTime.poll()[0]);
            }
            if (availableRooms.isEmpty()) {
                Long[] earliestAvailableRoom = roomNumberAndOpenTime.poll();
                Long roomNumber = earliestAvailableRoom[0];
                Long availableTime = earliestAvailableRoom[1];
                Long duration = (long)meeting[1] - meeting[0];
                Long newEndTime = availableTime + duration;
                System.out.println(roomNumber + " : " + newEndTime);
                roomNumberAndOpenTime.offer(new Long[]{roomNumber, newEndTime});
                roomToNumBookings.put(roomNumber, roomToNumBookings.getOrDefault(roomNumber, 0) + 1);
            } else {
                Long smallestRoomNumber = availableRooms.stream().mapToLong(a -> a).min().getAsLong();
                System.out.println(smallestRoomNumber + " : " + meeting[1]);
                roomNumberAndOpenTime.offer(new Long[]{smallestRoomNumber, (long)meeting[1]});
                for (Long availableRoom : availableRooms) {
                    if (!availableRoom.equals(smallestRoomNumber)) {
                        roomNumberAndOpenTime.offer(new Long[]{availableRoom, 0L});
                    }
                }
                roomToNumBookings.put(smallestRoomNumber, roomToNumBookings.getOrDefault(smallestRoomNumber, 0) + 1);
            }
        }

        Integer mostMeetings = Integer.MIN_VALUE;
        Integer mostMetRoom = 0;
        for (Long key : roomToNumBookings.keySet()) {
            if (roomToNumBookings.get(key) > mostMeetings) {
                mostMetRoom = key.intValue();
                mostMeetings = roomToNumBookings.get(key);
            } else if (roomToNumBookings.get(key) == mostMeetings && key < mostMetRoom) {
                mostMetRoom = key.intValue();
                mostMeetings = roomToNumBookings.get(key);
            }
        }

        return mostMetRoom;

    }
}