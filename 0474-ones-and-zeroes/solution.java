class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        List<Integer[]> counts = new ArrayList<>();

        for (String str : strs) {
            Integer ones = 0;
            Integer zeros = 0;
            for (Character ch : str.toCharArray()) {
                if (ch == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            counts.add(new Integer[]{zeros, ones});
        }
        return dfsFindMaxForm(counts, 0, n, m, new HashMap<>());
    }

    public int dfsFindMaxForm(List<Integer[]> counts, int index, int onesRemaining, int zerosRemaining, HashMap<String, Integer> cache) {
        String key = index + "," + onesRemaining + "," + zerosRemaining;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (index == counts.size()) {
            return 0;
        }

        //Take current Index
        int take = 0;
        if (onesRemaining - counts.get(index)[1] >= 0 && zerosRemaining - counts.get(index)[0] >= 0) {
            take =  1 + dfsFindMaxForm(counts, index + 1, onesRemaining - counts.get(index)[1], zerosRemaining - counts.get(index)[0], cache);
        }

        //skip current index
        int skip = dfsFindMaxForm(counts, index + 1, onesRemaining, zerosRemaining, cache);
        cache.put(key, Math.max(take, skip));
        return Math.max(take, skip);
    }
}