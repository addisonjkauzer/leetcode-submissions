class Solution {
    public boolean isPalindrome(String s) {
        String lowercase = s.toLowerCase();
        String alphaNumeric  = lowercase.replaceAll("[^A-Za-z0-9]", "");
        char[] charArray = alphaNumeric.toCharArray();
        int startPointer = 0;
        int endPointer = charArray.length - 1;
        
        while (startPointer < endPointer) {
            if(charArray[startPointer] != charArray[endPointer]) {
                return false;
            }
            startPointer++;
            endPointer--;
        }
        
        return true;
    }
}