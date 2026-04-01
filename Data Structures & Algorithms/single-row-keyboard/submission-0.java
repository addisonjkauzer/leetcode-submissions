class Solution {
    public int calculateTime(String keyboard, String word) {
        HashMap<Character, Integer> characterToIndex = new HashMap<>();

        for (int i = 0; i < keyboard.length(); i++) {
            Character character = keyboard.charAt(i);
            characterToIndex.put(character, i);
        }

        Integer totalDistance = 0;
        Integer currentIndex = 0;
        for (int i = 0; i < word.length(); i++) {
            Integer nextIndex = characterToIndex.get(word.charAt(i));
            totalDistance += (int)Math.abs(currentIndex - nextIndex);
            currentIndex = nextIndex;
        }
        return totalDistance;
    }
}
