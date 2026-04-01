class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final HashMap<Integer, Integer> occuranceCounter = new HashMap<>();

        for (Integer num : nums) {
            occuranceCounter.put(num, occuranceCounter.getOrDefault(num, 0) + 1);
        }

        final PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (final Map.Entry<Integer, Integer> entry : occuranceCounter.entrySet()) {
            maxHeap.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        int[] answer = new int[k];
        for(int i=0; i<k; i++) {
            answer[i] = maxHeap.poll()[1];
        }
        return answer;
    }
}
