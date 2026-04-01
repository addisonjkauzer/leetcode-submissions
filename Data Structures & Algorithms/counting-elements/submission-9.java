class Solution {
    public int countElements(int[] arr) {
        Set<Integer> counter = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        int count = 0;
        for (Integer key : arr) {
            if (counter.contains(key + 1)) {
                count += 1;
            }
        }
        return count;
    }
}
