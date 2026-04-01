class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, 1, new HashSet<>(wordDict), new HashMap<>());
    }

    public Boolean wordBreak(String s, Integer startIndex, Integer endIndex, Set<String> wordDict, HashMap<Integer, Boolean> cache) {
        if (cache.containsKey(startIndex)) {
            return cache.get(startIndex);
        }
        if (startIndex == s.length()) {
            return true;
        }
        if (endIndex > s.length()) {
            return false;
        }
        String word = s.substring(startIndex, endIndex);
        if (wordDict.contains(word)) {
            Boolean canWordBreak = wordBreak(s, endIndex, endIndex + 1, wordDict, cache);
            if (canWordBreak) {
                cache.put(startIndex, canWordBreak);
                return canWordBreak;
            }
        }
        Boolean canWordBreak = wordBreak(s, startIndex, endIndex + 1, wordDict, cache);
        cache.put(startIndex, canWordBreak);
        return canWordBreak;
    }


}
