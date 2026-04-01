class Solution {
    public int countElements(int[] arr) {
        TreeMap<Integer, Integer> counter = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            counter.put(arr[i], counter.getOrDefault(arr[i], 0) + 1);
        }
        int count = 0;
        for (Integer key : counter.keySet()) {
            if (counter.containsKey(key + 1)) {
                count += counter.get(key);
            }
            System.out.println(key + " made count = " + count);
        }
        return count;
    }
}
