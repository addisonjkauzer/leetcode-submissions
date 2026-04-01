class Solution {
    public String minWindow(String s, String t) {

        final HashMap<Character, Integer> characterCountsGoal = new HashMap<>();
        String shortestSubstring = s;
        Boolean isSolved = false;

        for (final Character character : t.toCharArray()) {
            characterCountsGoal.put(character, characterCountsGoal.getOrDefault(character, 0) + 1);
        }

        HashMap<Character, Integer> runningCharacterCounts = new HashMap<>();
        Integer leftPointer = 0;
        for (Integer rightPointer = 0; rightPointer < s.length(); rightPointer++){
            final Character currentCharacter = s.charAt(rightPointer);
            runningCharacterCounts.put(currentCharacter, runningCharacterCounts.getOrDefault(currentCharacter, 0) + 1);
            while (isSolved(characterCountsGoal, runningCharacterCounts)) {
                isSolved = true;
                final String solvedSubstring = s.substring(leftPointer, rightPointer + 1);
                if (solvedSubstring.length() < shortestSubstring.length()) {
                    shortestSubstring = solvedSubstring;
                }
                final Character leftCharacter = s.charAt(leftPointer);
                runningCharacterCounts.put(leftCharacter, runningCharacterCounts.get(leftCharacter) - 1);
                leftPointer++;
            }
        }
        return isSolved ? shortestSubstring : "";
    }

    public boolean isSolved(final HashMap<Character, Integer> goal, final HashMap<Character, Integer> running) {
        for (final Character key : goal.keySet()) {
            final Integer goalCount = goal.get(key);
            final Integer runningCount = running.getOrDefault(key, 0);
            if (goalCount > runningCount) {
                return false;
            }
        }
        return true;
    }
}
