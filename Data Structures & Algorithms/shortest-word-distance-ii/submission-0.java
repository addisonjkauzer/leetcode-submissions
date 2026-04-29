class WordDistance {

    Map<String, Integer> wordToDiff;

    public WordDistance(String[] wordsDict) {

        wordToDiff = new HashMap<>();

        for (int i = 0; i < wordsDict.length; i++) {
            String word1 = wordsDict[i];
            for (int j = i+1; j < wordsDict.length; j++) {
                String word2 = wordsDict[j];
                String combined = word1 + '/' + word2;
                if (wordToDiff.containsKey(combined) && wordToDiff.get(combined) < j - i) {
                    continue;
                }
                wordToDiff.put(combined, j - i);
            }
        }
        
    }
    
    public int shortest(String word1, String word2) {
        return Math.min(wordToDiff.getOrDefault(word1 + '/' + word2, Integer.MAX_VALUE), wordToDiff.getOrDefault(word2+ '/' + word1, Integer.MAX_VALUE));
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
