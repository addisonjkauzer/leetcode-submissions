class Solution {
    public boolean isPalindrome(String s) {
        Integer leftPointer = 0;
        Integer rightPointer = s.length() - 1;
        String lowerCaseString = s.toLowerCase();

        while (leftPointer <= rightPointer) {
            final Character leftCharacter = lowerCaseString.charAt(leftPointer);
            final Character rightCharacter = lowerCaseString.charAt(rightPointer);
            if (!Character.isLetterOrDigit(leftCharacter)) {
                leftPointer++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightCharacter)) {
                rightPointer--;
                continue;
            }
            if (!leftCharacter.equals(rightCharacter)) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
        
    }
}
