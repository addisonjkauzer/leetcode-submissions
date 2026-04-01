class Solution {
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            Integer leftPointer = i;
            Integer rightPointer = i;
            while (leftPointer >= 0 && rightPointer < s.length() && s.charAt(leftPointer) == s.charAt(rightPointer)) {
                leftPointer--;
                rightPointer++;
            }
            String palindrome = s.substring(leftPointer + 1, rightPointer);
            if (palindrome.length() > longestPalindrome.length()) {
                longestPalindrome = palindrome;
            }

            leftPointer = i;
            rightPointer = i + 1;
            while (leftPointer >= 0 && rightPointer < s.length() && s.charAt(leftPointer) == s.charAt(rightPointer)) {
                leftPointer--;
                rightPointer++;
            }
            palindrome = s.substring(leftPointer + 1, rightPointer);
            if (palindrome.length() > longestPalindrome.length()) {
                longestPalindrome = palindrome;
            }
        }
        return longestPalindrome;
    }
}
