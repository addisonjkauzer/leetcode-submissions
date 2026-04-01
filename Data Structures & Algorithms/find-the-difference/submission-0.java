class Solution {
    public char findTheDifference(String s, String t) {
        int differenceFinder = 0;

        for (char character : s.toCharArray()) {
            differenceFinder ^= character;
        }

        for (char character : t.toCharArray()) {
            differenceFinder ^= character;
        }

        return (char)differenceFinder;
        
    }
}