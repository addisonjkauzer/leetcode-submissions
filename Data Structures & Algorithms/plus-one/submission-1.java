class Solution {
    public int[] plusOne(int[] digits) {
        Integer index = digits.length - 1;
        while (index >= 0 && digits[index] == 9) {
            digits[index] = 0;
            index--;
        }

        if (index == -1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
        digits[index]++;
        return digits;
    }
}
