class Solution {
    public int missingNumber(int[] arr) {
        int firstValue = arr[0];
        int lastValue = arr[arr.length - 1];
        int difference = lastValue - firstValue;
        int differencePerStep = difference / arr.length;

        for (int i = 0; i < arr.length - 1; i++) {
            int current = arr[i];
            int next = arr[i+1];
            int expected = current + differencePerStep;
            if (next != expected) {
                return expected;
            }
        }
        return arr[0];
    }
}
