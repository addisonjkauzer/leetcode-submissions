class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> characterCounter = new HashMap<>();
        for (Character character : s.toCharArray()) {
            Integer newCount = characterCounter.getOrDefault(character, 0);
            newCount++;
            characterCounter.put(character, newCount);
        }
        for (Character character : t.toCharArray()) {
            Integer newCount = characterCounter.getOrDefault(character, 0);
            newCount--;
            characterCounter.put(character, newCount);
        }
        for (Integer count : characterCounter.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;

    }
}
