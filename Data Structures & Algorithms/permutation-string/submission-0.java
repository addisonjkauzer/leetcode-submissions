class Solution {
    public boolean checkInclusion(String s1, String s2) {
        final HashMap<Character, Integer> s1Characters = new HashMap<>();
        HashMap<Character, Integer> s2Characters = new HashMap<>();
        Integer totalCharacters = 0;

        for (final Character character : s1.toCharArray()) {
            s1Characters.put(character, s1Characters.getOrDefault(character, 0) + 1);
            totalCharacters++;
        }

        Integer leftPointer = 0;
        for (int rightPointer = 0; rightPointer < s2.length(); rightPointer++) {
            final Character currents2Character = s2.charAt(rightPointer);
            if (s1Characters.keySet().contains(currents2Character)) {
                s2Characters.put(currents2Character, s2Characters.getOrDefault(currents2Character, 0) + 1);
                while (s2Characters.get(currents2Character) > s1Characters.get(currents2Character)) {
                    final Character leftPointerCharacter = s2.charAt(leftPointer);
                    s2Characters.put(leftPointerCharacter, s2Characters.get(leftPointerCharacter) - 1);
                    leftPointer++;
                }
                if (totalCharacters == rightPointer - leftPointer + 1) {
                    return true;
                }
            } else {
                s2Characters = new HashMap<>();
                leftPointer = rightPointer + 1;
            }
        }
        return false;
        
    }
}
