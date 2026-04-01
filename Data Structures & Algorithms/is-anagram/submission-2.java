class Solution {
    public boolean isAnagram(String s, String t) {
        final HashMap<Character, Integer> characterCounter = new HashMap<>();

        for (final Character character : s.toCharArray()) {
            characterCounter.put(character, characterCounter.getOrDefault(character, 0) + 1);
        }
        for (final Character character : t.toCharArray()) {
            characterCounter.put(character, characterCounter.getOrDefault(character, 0) - 1);
        }

        for (final Integer value : characterCounter.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
