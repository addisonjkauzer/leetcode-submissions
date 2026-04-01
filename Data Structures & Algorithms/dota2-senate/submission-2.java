class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiantIndexes = new LinkedList<>();
        Queue<Integer> direIndexes = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            Character character = senate.charAt(i);
            if (character == 'R') {
                radiantIndexes.add(i);
            } else {
                direIndexes.add(i);
            }
        }
        Integer currentIndex = 0;
        while (!radiantIndexes.isEmpty() && !direIndexes.isEmpty()) {
            Integer closestRadiantIndex = radiantIndexes.peek();
            Integer closestDireIndex = direIndexes.peek();
            if (closestRadiantIndex < closestDireIndex) {
                Integer votingIndex = radiantIndexes.poll();
                radiantIndexes.add(senate.length() + votingIndex);
                direIndexes.poll();
            } else {
                Integer votingIndex = direIndexes.poll();
                direIndexes.add(senate.length() + votingIndex);
                radiantIndexes.poll();
            }
        }
        return radiantIndexes.isEmpty() ? "Dire" : "Radiant";
    }
}