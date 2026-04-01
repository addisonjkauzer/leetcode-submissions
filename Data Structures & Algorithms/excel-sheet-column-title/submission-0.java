class Solution {
    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0) {
            return "";
        }
        int newColNumber = columnNumber - 1;
        return convertToTitle(newColNumber / 26) + (char)('A' + newColNumber % 26);
    }
}