class Solution {
    public boolean checkValidString(String s) {
        int maxLeftParen = 0;
        int minLeftParen = 0;

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                    maxLeftParen++;
                    minLeftParen++;
                    break;
                case ')':
                    maxLeftParen--;
                    minLeftParen--;
                    break;
                case '*':
                    maxLeftParen++;
                    minLeftParen--;
                    break;
            }
            if (maxLeftParen < 0) {
                return false;
            }
            if (minLeftParen < 0) {
                minLeftParen = 0;
            }
        }
        return minLeftParen == 0;
    }
}
