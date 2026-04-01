class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        HashMap<String, Set<String>> similarityMap = new HashMap<>();
        for (int i = 0; i < similarPairs.size(); i++) {
            String word1 = similarPairs.get(i).get(0);
            String word2 = similarPairs.get(i).get(1);
            Set<String> word1Similars = similarityMap.getOrDefault(word1, new HashSet<>());
            Set<String> word2Similars = similarityMap.getOrDefault(word2, new HashSet<>());
            word2Similars.add(word1);
            word1Similars.add(word2);
            similarityMap.put(word1, word1Similars);
            similarityMap.put(word2, word2Similars);
        }

        if (sentence1.length != sentence2.length) {
            return false;
        }
        for (int i = 0; i < sentence1.length; i++) {
            Set<String> similarWords = similarityMap.getOrDefault(sentence1[i], new HashSet<>());
            if (!similarWords.contains(sentence2[i]) && !sentence1[i].equals(sentence2[i])) {
                return false;
            }
        }
        return true;
    }
}
