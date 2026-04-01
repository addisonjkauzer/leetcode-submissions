class Solution {
    public int characterReplacement(String s, int k) {

        if (invalidInput(s, k)) {
            return -1;
        }

        final HashMap<Character, Integer> characterCounter = new HashMap<>();
        Integer duplicatesCounter = 0;
        Integer leftPointer = 0;
        Integer maxLength = 0;
        Integer mostCommonCharacterCount = 0;

        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            final Character rightCharacter = s.charAt(rightPointer);
            final Integer rightCharacterCount = characterCounter.getOrDefault(rightCharacter, 0) + 1;
            characterCounter.put(rightCharacter, rightCharacterCount);

            mostCommonCharacterCount = Math.max(mostCommonCharacterCount, rightCharacterCount);
            while (rightPointer - leftPointer + 1 - mostCommonCharacterCount > k) {
                final Character leftCharacter = s.charAt(leftPointer);
                final Integer leftCharacterCount = characterCounter.get(leftCharacter) - 1;
                characterCounter.put(leftCharacter, leftCharacterCount);
                leftPointer++;
            }
            maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
        }
        return maxLength;
    }

    public Boolean invalidInput(final String s, final Integer k) {
        if (s.length() < 1) {
            return true;
        }
        if (k < 0) {
            return true;
        }
        return false;
    }
}
