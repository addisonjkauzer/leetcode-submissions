class Solution {
    public String reverseParentheses(String s) {
        StringBuilder strBuilder = new StringBuilder(s);
        Stack<Integer> openParenIndexes = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openParenIndexes.push(i);
            } else if (s.charAt(i) == ')') {
                reverse(strBuilder, openParenIndexes.pop(), i);
            }
        }

        return strBuilder.toString().replace("(","").replace(")","");
    }

    public void reverse(StringBuilder s, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            char temp = s.charAt(startIndex);
            s.setCharAt(startIndex, s.charAt(endIndex));
            s.setCharAt(endIndex, temp); 
            startIndex++;
            endIndex--;
        }
    }
}