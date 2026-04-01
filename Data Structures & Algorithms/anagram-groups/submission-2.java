class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final HashMap<String, List<String>> anagramGroups = new HashMap<>();
        for (final String string : strs) {
            boolean anagramFound = false;
            for (final String key : anagramGroups.keySet()) {
                if (isAnagram(key, string)) {
                    final List<String> anagramGroup = anagramGroups.get(key);
                    anagramGroup.add(string);
                    anagramGroups.put(key, anagramGroup);
                    anagramFound = true;
                    break;
                }
            }
            if (!anagramFound) {
                final List<String> anagramGroup = new ArrayList<>(Arrays.asList(string));
                anagramGroups.put(string, anagramGroup);
            }
        }

        final List<List<String>> returned = new ArrayList<>();

        for (final List<String> anagramGroup : anagramGroups.values()) {
            returned.add(anagramGroup);
        }
        return returned;
    }

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
