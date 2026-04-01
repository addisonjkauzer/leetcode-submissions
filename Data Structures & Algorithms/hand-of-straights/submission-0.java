class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> cardCounter = new TreeMap<>();

        for (int card : hand) {
            cardCounter.put(card, cardCounter.getOrDefault(card, 0) + 1);
        }
        while (!cardCounter.isEmpty()) {
            Integer currentKey = cardCounter.firstKey();
            for (int i = 0; i < groupSize; i++) {
                if (!cardCounter.containsKey(currentKey)) {
                    return false;
                }
                Integer currentCardCount = cardCounter.get(currentKey);
                currentCardCount--;
                if (currentCardCount == 0) {
                    cardCounter.remove(currentKey);
                } else {
                    cardCounter.put(currentKey, currentCardCount);
                }
                currentKey++;
            }
        }
        return true;


        
    }
}
