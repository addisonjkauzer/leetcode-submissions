class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groupedAnagrams = new HashMap<>();
        for (String word : strs) {
            Boolean keyFound = false;
            for (String key : groupedAnagrams.keySet()) {
                if (isAnagram(word,key)) {
                    List<String> values = groupedAnagrams.get(key);
                    values.add(word);
                    groupedAnagrams.put(key, values);
                    keyFound = true;
                    break;
                }
            }
            if (!keyFound) {
                List<String> newValues = new ArrayList();
                newValues.add(word);
                groupedAnagrams.put(word, newValues);
            }
        }

        List<List<String>> listGroupedAnagrams = new ArrayList<>();
        for (List<String> values : groupedAnagrams.values()) {
            listGroupedAnagrams.add(values);
        }
        return listGroupedAnagrams;

        
    }

    public Boolean isAnagram(String firstString, String secondString) {
        HashMap<Character, Integer> characterCounter = new HashMap<>();
        for (Character character : firstString.toCharArray()) {
            Integer count = characterCounter.getOrDefault(character, 0);
            count++;
            characterCounter.put(character, count);
        }
        for (char character : secondString.toCharArray()) {
            Integer count = characterCounter.getOrDefault(character, 0);
            count--;
            characterCounter.put(character, count);
        }

        for (Integer value : characterCounter.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
