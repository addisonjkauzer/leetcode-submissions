class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> characterToCount = new HashMap();
        int start = 0;
        int maxCount = 0;
        char[] characters = s.toCharArray();
        int maxLength = 0;

        for(int end = 0; end < s.length(); end++) {
            int currentCount = characterToCount.getOrDefault(characters[end], 0);
            currentCount++;
            characterToCount.put(characters[end], currentCount);

            maxCount = Math.max(maxCount, currentCount);

            while(end - start + 1 > k + maxCount) {
                int startCharacterCount = characterToCount.get(characters[start]);
                startCharacterCount--;
                characterToCount.put(characters[start], startCharacterCount);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;

    }
}