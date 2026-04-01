class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> characterCounter = new HashMap<>();

        for (char task : tasks) {
            characterCounter.put(task, characterCounter.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (Integer count : characterCounter.values()) {
            maxHeap.add(count);
        }

        Queue<Integer[]> waitingQueue = new LinkedList<>();

        Integer time = 0;

        while(!maxHeap.isEmpty() || !waitingQueue.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                Integer currentTaskCount = maxHeap.poll();
                currentTaskCount--;
                if (currentTaskCount > 0) {
                    waitingQueue.add(new Integer[]{currentTaskCount, time + n});
                }
            }  

            while (!waitingQueue.isEmpty() && waitingQueue.peek()[1] <= time) {
                maxHeap.add(waitingQueue.poll()[0]);
            }
        }
        return time;
        
        
    }
}
