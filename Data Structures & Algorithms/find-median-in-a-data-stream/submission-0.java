class MedianFinder {
    PriorityQueue<Integer> maxHeapLeft;
    PriorityQueue<Integer> minHeapRight;

    public MedianFinder() {
        maxHeapLeft = new PriorityQueue<>(Collections.reverseOrder());
        minHeapRight = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeapLeft.isEmpty()) {
            maxHeapLeft.add(num);
            return;
        }
        Integer maxValueOfLeft = maxHeapLeft.peek();

        if (num < maxValueOfLeft) {
            maxHeapLeft.add(num);
        } else {
            minHeapRight.add(num);
        }
        while (maxHeapLeft.size() > minHeapRight.size()) {
            minHeapRight.add(maxHeapLeft.poll());
        }
        while (maxHeapLeft.size() < minHeapRight.size()) {
            maxHeapLeft.add(minHeapRight.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeapLeft.size() > minHeapRight.size()) {
            return maxHeapLeft.peek();
        } else if (maxHeapLeft.size() < minHeapRight.size()) {
            return minHeapRight.peek();
        } else {
            return (maxHeapLeft.peek() + minHeapRight.peek()) / 2.0;
        }
    }
}
