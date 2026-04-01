class Solution {
    public boolean isStrobogrammatic(String num) {
        int rightPointer = num.length() - 1;
        int leftPointer = 0;
        while (leftPointer <= rightPointer) {
            if (!isSame(num.charAt(leftPointer), num.charAt(rightPointer))) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    public boolean isSame(char num1, char num2) {
        if (num1 == '6' && num2 == '9') {
            return true;
        }
        if (num1 == '9' && num2 == '6') {
            return true;
        }
        if (num1 == '8' && num2 == '8') {
            return true;
        }
        if (num1 == '0' && num2 == '0') {
            return true;
        }
        if (num1 == '1' && num2 == '1') {
            return true;
        }
        return false;
    }
}
