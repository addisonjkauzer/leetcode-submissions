class Solution {
    public int lengthOfLongestSubstring(String s) {
        Integer leftPointer = 0;
        Integer rightPointer = 0;
        Integer maxLength = 0;

        HashSet<String> uniqueCharacters = new HashSet<>();

        while (rightPointer < s.length()) {
            if (uniqueCharacters.contains(s.substring(rightPointer, rightPointer + 1))) {
                uniqueCharacters.remove(s.substring(leftPointer, leftPointer + 1));
                leftPointer++;
            } else {
                uniqueCharacters.add(s.substring(rightPointer, rightPointer + 1));
                maxLength = Math.max(uniqueCharacters.size(), maxLength);
                rightPointer++;
            }
        }
        return maxLength;
    }
}
