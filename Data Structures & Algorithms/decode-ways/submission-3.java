class Solution {
    public int numDecodings(String s) {
        return numDecodings(s, 0, new HashMap<>());
    }

    public int numDecodings(String s, Integer index, HashMap<Integer, Integer> cache) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        if (index == s.length() + 1) {
            return 0;
        }
        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (s.charAt(index) == '1') {
            if (index != s.length() - 1 && s.charAt(index + 1) == '0') {
                Integer decodings = numDecodings(s, index + 2, cache);
                cache.put(index, decodings);
                return decodings;
            }
            Integer decodings = numDecodings(s, index + 1, cache) + numDecodings(s, index + 2, cache);
            cache.put(index, decodings);
            return decodings;
        }

        if (s.charAt(index) == '2') {
            if (index != s.length() - 1 && s.charAt(index + 1) == '0') {
                Integer decodings =  numDecodings(s, index + 2, cache);
                cache.put(index, decodings);
                return decodings;
            }
            if (index != s.length() - 1 && (s.charAt(index + 1) == '1' || s.charAt(index + 1) == '2' || s.charAt(index + 1) == '3' || s.charAt(index + 1) == '4' || s.charAt(index + 1) == '5' || s.charAt(index + 1) == '6')) {
                Integer decodings = numDecodings(s, index + 1, cache) + numDecodings(s, index + 2, cache);
                cache.put(index, decodings);
                return decodings;
            }
        }
        Integer decodings = numDecodings(s, index + 1, cache);
        cache.put(index, decodings);
        return decodings;
        
    }
}
