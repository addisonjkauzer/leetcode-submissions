class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        List<Integer[]> combined = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            combined.add(new Integer[]{nums1[i], nums2[i]});
        }
        Collections.sort(combined, Collections.reverseOrder(Comparator.comparing(a -> a[1])));
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Long sum = 0L;
        Long result = 0L;
        for (Integer[] nums : combined) {
            sum += nums[0];
            minHeap.offer(nums[0]);
            if (minHeap.size() > k) {
                sum -= minHeap.remove();
            }

            if (minHeap.size() == k) {
                result = Math.max(result, sum * nums[1]);
            }
        }
        return result;
    }
}