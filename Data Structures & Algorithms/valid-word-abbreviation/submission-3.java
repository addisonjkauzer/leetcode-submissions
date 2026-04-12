class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int abbrIndex = 0;
        int wordIndex = 0;
        while (wordIndex < word.length()) {
            if (abbrIndex < abbr.length() && Character.isLetter(abbr.charAt(abbrIndex))) {
                if (word.charAt(wordIndex) != abbr.charAt(abbrIndex)) {
                    return false;
                } else {
                    abbrIndex++;
                    wordIndex++;
                    continue;
                }
            }
            if (abbrIndex < abbr.length() && abbr.charAt(abbrIndex) == '0') {
                return false;
            }
            String number = "";
            int multiplier = 1;
            while (abbrIndex < abbr.length() && !Character.isLetter(abbr.charAt(abbrIndex))) {
                number += abbr.charAt(abbrIndex);
                abbrIndex++;
            }
            wordIndex += Integer.parseInt(number);
            System.out.println(wordIndex);
        }
        if (wordIndex == word.length() && abbrIndex == abbr.length()) {
            return true;
        } else {
            return false;
        }
    }
}