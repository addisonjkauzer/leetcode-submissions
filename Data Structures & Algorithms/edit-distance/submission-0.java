class Solution {
    public int minDistance(String word1, String word2) {
        return dfsMinDistance(word1.toCharArray(), word2.toCharArray(), 0, 0, new HashMap<>());
    }

    public int dfsMinDistance(char[] word1, char[] word2, Integer index1, Integer index2, HashMap<List<Integer>, Integer> cache) {
        if (cache.containsKey(Arrays.asList(index1, index2))) {
            return cache.get(Arrays.asList(index1, index2));
        }
        if (index1 == word1.length) {
            return word2.length - index2;
        }
        if (index2 == word2.length) {
            return word1.length - index1;
        }
        if (word1[index1] == word2[index2]) {
            Integer minDistance = dfsMinDistance(word1, word2, index1 + 1, index2 + 1, cache);
            cache.put(Arrays.asList(index1, index2), minDistance);
            return minDistance;
        }
        Integer insertLetter = dfsMinDistance(word1, word2, index1, index2 + 1, cache) + 1;
        Integer deleteLetter = dfsMinDistance(word1, word2, index1 + 1, index2, cache) + 1;
        Integer replaceLetter = dfsMinDistance(word1, word2, index1 + 1, index2 + 1, cache) + 1;
        Integer minDistance = Math.min(insertLetter, Math.min(deleteLetter, replaceLetter));
        cache.put(Arrays.asList(index1, index2), minDistance);
        return minDistance;
    }
}
