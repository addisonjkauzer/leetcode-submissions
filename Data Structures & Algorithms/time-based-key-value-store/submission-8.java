class TimeMap {

    HashMap<String, List<Object[]>> keyToList;

    public TimeMap() {
        keyToList = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        final List<Object[]> existingList = keyToList.getOrDefault(key, new ArrayList());
        existingList.add(new Object[] {value, timestamp});
        keyToList.put(key, existingList);
    }
    
    public String get(String key, int timestamp) {
        if (!keyToList.containsKey(key)) {
            return "";
        }
        final List<Object[]> value = keyToList.get(key);
        int leftPointer = 0;
        int rightPointer = value.size() - 1;
        while (leftPointer <= rightPointer) {
            final Integer middlePointer = leftPointer + (rightPointer - leftPointer) / 2;
            final Object[] middleValueAndTimestamp = value.get(middlePointer);
            final Integer middleTimestamp = (Integer)middleValueAndTimestamp[1];
            final String middleValue = String.valueOf(middleValueAndTimestamp[0]);

            if (timestamp < middleTimestamp) {
                rightPointer = middlePointer - 1;
            } else if (timestamp > middleTimestamp) {
                leftPointer = middlePointer + 1;
            } else {
                return middleValue;
            }
        }
        Integer rightPointerOrZero = Math.max(rightPointer, 0);
        if ((Integer)value.get(rightPointerOrZero)[1] > timestamp) {
            return "";
        } else {
            return String.valueOf(value.get(rightPointerOrZero)[0]);
        }
    }
}
