class Solution {
    public int numDistinct(String s, String t) {
        return dfsNumDistinct(s.toCharArray(), t.toCharArray(), 0, 0, new HashMap<>());
    }

    public int dfsNumDistinct(final char[] s, final char[] t, final Integer sIndex, final Integer tIndex, final HashMap<List<Integer>, Integer> cache) {
        if (cache.containsKey(Arrays.asList(sIndex, tIndex))) {
            return cache.get(Arrays.asList(sIndex, tIndex));
        }
        if (sIndex == s.length && tIndex < t.length) {
            return 0;
        }
        if (tIndex == t.length) {
            return 1;
        }
        final Integer dontTake = dfsNumDistinct(s, t, sIndex + 1, tIndex, cache);
        if (s[sIndex] == t[tIndex]) {
            final Integer takeCurrent = dfsNumDistinct(s, t, sIndex+1, tIndex+1, cache);
            cache.put(Arrays.asList(sIndex, tIndex), takeCurrent + dontTake);
            return takeCurrent + dontTake;
        }
        cache.put(Arrays.asList(sIndex, tIndex), dontTake);
        return dontTake;
    }
}
