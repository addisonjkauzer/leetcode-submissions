class KthLargest {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    Integer k;

    public KthLargest(int k, int[] nums) {
        for (Integer num : nums) {
            maxHeap.add(num);
        }
        this.k = k;
    }
    
    public int add(int val) {
        maxHeap.add(val);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            values.add(maxHeap.poll());
        }
        for (Integer value : values) {
            maxHeap.add(value);
        }
        return values.get(values.size() - 1);
    }
}
