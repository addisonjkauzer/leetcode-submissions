class Solution {
    public int[] replaceElements(int[] arr) {
        Integer currentMax = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] <= currentMax) {
                arr[i] = currentMax;
            } else {
                Integer temp = arr[i];
                arr[i] = currentMax;
                currentMax = temp;
            }
        }
        return arr;
    }
}