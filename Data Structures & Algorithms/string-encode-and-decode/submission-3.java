class Solution {

    public String encode(List<String> strs) {
        String encodedString = "";
        for (String string : strs) {
            encodedString = encodedString + string.length() + "#" + string;
        }
        System.out.println(encodedString);
        return encodedString;
    }

    public List<String> decode(String str) {
        final List<String> decodedValues = new ArrayList<>();
        Integer currentCharacterIndex = 0;
        while(currentCharacterIndex < str.length()) {
            String lengthString = "";
            while(!str.substring(currentCharacterIndex, currentCharacterIndex + 1).equals("#")) {
                lengthString = lengthString + str.substring(currentCharacterIndex, currentCharacterIndex + 1);
                currentCharacterIndex++;
            }
            currentCharacterIndex++;
            System.out.println(lengthString);
            Integer length = Integer.parseInt(lengthString);
            String decodedWord = "";
            Integer endIndex = currentCharacterIndex + length;
            while (currentCharacterIndex < endIndex) {
                decodedWord = decodedWord + str.charAt(currentCharacterIndex);
                currentCharacterIndex++;
            }
            decodedValues.add(decodedWord);
        }
        return decodedValues;
    }
}
