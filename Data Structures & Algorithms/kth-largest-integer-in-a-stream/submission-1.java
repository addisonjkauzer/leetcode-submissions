class KthLargest {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    Integer k;

    public KthLargest(int k, int[] nums) {
        for (Integer num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        this.k = k;
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
