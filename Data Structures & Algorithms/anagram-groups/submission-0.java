class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groupedAnagrams = new HashMap<>();
        for (String word : strs) {
            boolean groupAlreadyExists = false;
            for (String key : groupedAnagrams.keySet()) {
                if (isAnagram(key, word)) {
                    ArrayList<String> anagramGroup = new ArrayList(groupedAnagrams.get(key));
                    anagramGroup.add(word);
                    groupedAnagrams.put(key, anagramGroup);
                    groupAlreadyExists = true;
                }
            }
            if (!groupAlreadyExists) {
                List<String> anagramGroup = Arrays.asList(word);
                groupedAnagrams.put(word, anagramGroup);
            }
        }
        return new ArrayList(groupedAnagrams.values());
    }

    private Boolean isAnagram(String word1, String word2) {
        HashMap<Character, Integer> characterCounter = new HashMap<>();
        for (Character character : word1.toCharArray()) {
            int newCount = characterCounter.getOrDefault(character, 0);
            newCount++;
            characterCounter.put(character, newCount);
        }
        for (Character character : word2.toCharArray()) {
            int newCount = characterCounter.getOrDefault(character, 0);
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
