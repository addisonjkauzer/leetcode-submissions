class Solution {
    public int appendCharacters(String s, String t) {
        int longestSubsequence = longestSubsequence(s.toCharArray(), t.toCharArray());
        return t.length() - longestSubsequence;
    }

    public int longestSubsequence(char[] s, char[] t) {
        int tIndex = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == t[tIndex]) {
                tIndex++;
                if (tIndex == t.length) break;
            }
        }
        return tIndex;
    }
}