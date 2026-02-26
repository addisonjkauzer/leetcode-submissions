class Solution {
    public int partitionString(String s) {
        int substringCount = 1;
        HashSet<Character> seen = new HashSet<>();
        for (Character character : s.toCharArray()) {
            if (seen.contains(character)) {
                seen.clear();
                substringCount++;
            }
            seen.add(character);
        }
        return substringCount;
        //return dfsPartitionString(s, 0, new HashSet<>());
    }

    public int dfsPartitionString(String s, int index, HashSet<Character> seen) {
        if (index == s.length()) {
            return 1;
        }

        //start new word
        int result = 1 + dfsPartitionString(s, index + 1, new HashSet<>());


        //continue word
        if (!seen.contains(s.charAt(index))) {
            seen.add(s.charAt(index));
            result = Math.min(result, dfsPartitionString(s, index + 1, seen));
        }

        return result;
    }
}