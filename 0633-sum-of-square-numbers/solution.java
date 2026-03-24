class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= (int)Math.sqrt(c); i++) {
            int firstNumber = i * i;
            int secondNumber = (int)Math.sqrt(c - firstNumber);
            if (firstNumber + secondNumber * secondNumber == c) {
                return true;
            }
        }
        return false;
    }
}