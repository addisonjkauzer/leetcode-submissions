class Solution {
    PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
    public int lastStoneWeight(int[] stones) {
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1) {
            Integer firstStone = maxHeap.poll();
            Integer secondStone = maxHeap.poll();

            if (firstStone == secondStone) {
                continue;
            } else {
                maxHeap.add(Math.abs(firstStone - secondStone));
            }
        }
        if (maxHeap.size() == 1) {
            return maxHeap.poll();
        }
        return 0;
        
    }
}
