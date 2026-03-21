class Solution {
    public String decodeString(String s) {
        return decodeString(s, 0, s.length());
    }

    public String decodeString(String s, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return "";
        }
        if (Character.isDigit(s.charAt(startIndex))) {
            String digit = "";
            while (Character.isDigit(s.charAt(startIndex))) {
                digit += s.charAt(startIndex);
                startIndex++;
            }
            int count = Integer.parseInt(digit);
            int endBracketIndex = getEndBracketIndex(s, startIndex);
            String decodedSegment = decodeString(s, startIndex + 1, endBracketIndex);
            String result = "";
            for (int i = 1; i <= count; i++) {
                result += decodedSegment;
            }
            return result + decodeString(s, endBracketIndex + 1, endIndex);
        } else {
            return s.charAt(startIndex) + decodeString(s, startIndex + 1, endIndex);
        }
    }

    public int getEndBracketIndex(String s, int openBracketIndex) {
        int openBracketCount = 1;
        int endBracketIndex = openBracketIndex + 1;
        while (openBracketCount != 0) {
            char ch = s.charAt(endBracketIndex);
            if (ch == '[') {
                openBracketCount++;
            }
            if (ch == ']') {
                openBracketCount--;
            }
            endBracketIndex++;
        }
        return endBracketIndex - 1;
    }
}