class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int leftPointer = 0;
        int rightPointer = 0;
        HashMap<Character, Integer> distinct = new HashMap<>();
        Integer maxLength = 0;
        while (rightPointer < s.length()) {
            Character currentChar = s.charAt(rightPointer);
            distinct.put(currentChar, distinct.getOrDefault(currentChar, 0) + 1);
            while (distinct.keySet().size() > k) {
                Character leftChar = s.charAt(leftPointer);
                distinct.put(leftChar, distinct.get(leftChar) - 1);
                if (distinct.get(leftChar) == 0) {
                    distinct.remove(leftChar);
                }
                leftPointer++;
            }
            rightPointer++;
            maxLength = Math.max(maxLength, rightPointer - leftPointer);
        }
        return maxLength;
    }
}
