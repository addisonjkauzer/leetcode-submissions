class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> allowedSet = new HashSet<>();
        for (char character : allowed.toCharArray()) {
            allowedSet.add(character);
        }
        int result = 0;
        for (String word : words) {
            boolean good = true;
            for (char character : word.toCharArray()) {
                if (!allowedSet.contains(character)) {
                    good = false;
                    break;
                }
            }
            if (good) result++;
        }
        return result;
    }
}