class Solution {

    public String encode(List<String> strs) {
        final StringBuilder encodedString = new StringBuilder();

        for (final String string : strs) {
            encodedString.append(string.length());
            encodedString.append("#");
            encodedString.append(string);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        if (str.length() <= 0) {
            return new ArrayList();
        }
        final StringBuilder wordLengthStringBuilder = new StringBuilder();
        Integer index = 0;
        for (final Character character : str.toCharArray()) {
            if (character.equals('#')) {
                index++;
                break;
            }
            wordLengthStringBuilder.append(character);
            index++;
        }
        final Integer wordLength = Integer.parseInt(wordLengthStringBuilder.toString());
        final StringBuilder decodedWord = new StringBuilder();
        for (int i=0; i < wordLength; i++) {
            decodedWord.append(str.charAt(index));
            index++;
        }

        final List<String> remainingWords = decode(str.substring(index));

        final List<String> decodedList = new ArrayList(Arrays.asList(decodedWord.toString()));
        for (final String remainingWord : remainingWords) {
            decodedList.add(remainingWord);
        }
        return decodedList;

    }
}
