class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        char[] charOrder = order.toCharArray();

        for (int wordIndex = 0; wordIndex < words.length - 1; wordIndex++) {
            char[] firstWord = words[wordIndex].toCharArray();
            char[] secondWord = words[wordIndex + 1].toCharArray();

            int charIndex = 0;
            while (charIndex < firstWord.length && charIndex < secondWord.length && firstWord[charIndex] == secondWord[charIndex]) {
                charIndex++;
            }
            if (charIndex == firstWord.length) {
                continue;
            }
            if (charIndex == secondWord.length) {
                return false;
            }
            
            for (int i = 0; i < charOrder.length; i++) {
                if (charOrder[i] == firstWord[charIndex]) {
                    break;
                }
                if (charOrder[i] == secondWord[charIndex]) {
                    return false;
                } 
            }
        }
        return true;
        
    }
}