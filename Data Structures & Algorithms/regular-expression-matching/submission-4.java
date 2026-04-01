class Solution {
    public boolean isMatch(String s, String p) {
        if (p.charAt(0) == '*') {
            return false;
        }
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0, new HashMap<>());
    }

    public boolean isMatch(char[] s, char[] p, Integer sIndex, Integer pIndex, HashMap<List<Integer>, Boolean> cache) {
        List<Integer> indexes = Arrays.asList(sIndex, pIndex);
        System.out.println(indexes);
        if (cache.containsKey(indexes)) {
            return cache.get(indexes);
        }
        if (sIndex == s.length && pIndex == p.length) {
            return true;
        }
        if (pIndex == p.length) {
            return false;
        }

        //Has wildcard attached
        boolean result = false;
        if (pIndex + 1 < p.length && p[pIndex + 1] == '*') {
            //don't use
            result = result || isMatch(s, p, sIndex, pIndex + 2, cache);
            //use
            char runningCharacter = p[pIndex];
            while (sIndex < s.length && (s[sIndex] == runningCharacter || runningCharacter == '.')) {
                result = result || isMatch(s, p, sIndex + 1, pIndex, cache);
                sIndex++;
            }
            cache.put(indexes, result);
            return result;
        }

        if (sIndex < s.length && (s[sIndex] == p[pIndex] || p[pIndex] == '.')) {
            result = result || isMatch(s, p, sIndex + 1, pIndex + 1, cache);
            cache.put(indexes, result);
            return result;
        }
        return false;
    }
}
