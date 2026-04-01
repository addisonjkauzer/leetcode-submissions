class Solution {
    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            maxHeap.offer(gift);
        }

        for (int i = 0; i < k; i++) {
            int gift = maxHeap.poll();
            int updatedGift = (int)Math.sqrt(gift);
            maxHeap.offer(updatedGift);
        }

        int sum = 0;
        for (int gift : maxHeap) {
            sum += gift;
        }

        return sum;
        
    }
}