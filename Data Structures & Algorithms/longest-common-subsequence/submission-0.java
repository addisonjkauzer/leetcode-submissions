class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        return dfs(text1.toCharArray(), text2.toCharArray(), 0, 0, new HashMap<>());
    }

    public int dfs(char[] text1, char[] text2, Integer i, Integer j, HashMap<List<Integer>, Integer> cache) {
        if (cache.containsKey(Arrays.asList(i, j))) {
            return cache.get(Arrays.asList(i, j));
        }
        if (i >= text1.length || j >= text2.length) {
            return 0;
        }
        if (text1[i] == text2[j]) {
            Integer result = 1 + dfs(text1, text2, i+1, j+1, cache);
            cache.put(Arrays.asList(i, j), result);
            return result;
        }
        Integer result1 = dfs(text1, text2, i+1, j, cache);
        Integer result2 = dfs(text1, text2, i, j+1, cache);
        Integer result = Math.max(result1, result2);
        cache.put(Arrays.asList(i,j), result);
        return result;
    }
}
