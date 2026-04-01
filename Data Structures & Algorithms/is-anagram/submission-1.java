class Solution {
    public boolean isAnagram(String s, String t) {
        final HashMap<Character, Integer> characterCounter = new HashMap<>();

        for (char character : s.toCharArray()) {
            Integer currentCount = characterCounter.getOrDefault(character, 0);
            currentCount++;
            characterCounter.put(character, currentCount);
        }

        for (char character : t.toCharArray()) {
            Integer currentCount = characterCounter.getOrDefault(character, 0);
            currentCount--;
            characterCounter.put(character, currentCount);
        }

        for (Integer value : characterCounter.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
