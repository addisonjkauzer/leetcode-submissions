class Solution {
    public int countSubstrings(String s) {
        Integer palindromes = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer leftPointer = i;
            Integer rightPointer = i;
            while (leftPointer >= 0 && rightPointer < s.length() && s.charAt(leftPointer) == s.charAt(rightPointer)) {
                leftPointer--;
                rightPointer++;
                palindromes++;
            }

            leftPointer = i;
            rightPointer = i + 1;
            while (leftPointer >= 0 && rightPointer < s.length() && s.charAt(leftPointer) == s.charAt(rightPointer)) {
                leftPointer--;
                rightPointer++;
                palindromes++;
            }
        }
        return palindromes;
    }
}
