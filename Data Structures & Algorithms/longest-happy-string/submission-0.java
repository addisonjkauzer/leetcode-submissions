class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Integer[]> maxHeap = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(f -> f[1])));

        maxHeap.add(new Integer[] {(int)'a', a});
        maxHeap.add(new Integer[] {(int)'b', b});
        maxHeap.add(new Integer[] {(int)'c', c});
        
        StringBuilder result = new StringBuilder();

        char lastChar = 'd';
        int lastCharCount = 0;

        while (!maxHeap.isEmpty()) {
            Integer[] currentMax = maxHeap.poll();
            char currentChar = (char)(int)currentMax[0];
            int currentCharRemaining = currentMax[1];
            if (currentCharRemaining == 0) {
                break;
            }
            if (currentChar == lastChar) {
                if (lastCharCount == 2) {
                    if (maxHeap.isEmpty()) {
                        break;
                    } else {
                        Integer[] secondMax = maxHeap.poll();
                        char secondChar = (char)(int)secondMax[0];
                        int secondCharRemaining = secondMax[1];
                        if (secondCharRemaining == 0) {
                            break;
                        }
                        result.append(secondChar);
                        lastChar = secondChar;
                        lastCharCount = 1;
                        maxHeap.offer(new Integer[]{(int)secondChar, secondCharRemaining - 1});
                        maxHeap.offer(currentMax);
                    }
                } else {
                   result.append(currentChar);
                   lastCharCount++; 
                   maxHeap.offer(new Integer[]{(int)currentChar, currentCharRemaining - 1});
                }
            } else {
                result.append(currentChar);
                lastChar = currentChar;
                lastCharCount = 1;
                maxHeap.offer(new Integer[]{(int)currentChar, currentCharRemaining - 1});
            }
        }
        return result.toString();
        
    }
}