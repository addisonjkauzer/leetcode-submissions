class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (Math.abs(s1.length() - s2.length()) > 1 || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return dfs(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, new HashMap<>());
    }

    public boolean dfs(char[] s1, char[] s2, char[] target, Integer s1Index, Integer s2Index, HashMap<List<Integer>, Boolean> cache) {
        if (cache.containsKey(Arrays.asList(s1Index, s2Index))) {
            return cache.get(Arrays.asList(s1Index, s2Index));
        }
        if (s1Index == s1.length && s2Index == s2.length) {
            return true;
        }
        boolean foundTarget = false;
        char targetCharacter = target[s1Index + s2Index];
        if (s1Index < s1.length && s1[s1Index] == targetCharacter) {
            foundTarget = foundTarget || dfs(s1, s2, target, s1Index + 1, s2Index, cache);
        }
        if (s2Index < s2.length && s2[s2Index] == targetCharacter) {
            foundTarget = foundTarget || dfs(s1, s2, target, s1Index, s2Index + 1, cache);
        }
        cache.put(Arrays.asList(s1Index, s2Index), foundTarget);
        return foundTarget;
    }
}
