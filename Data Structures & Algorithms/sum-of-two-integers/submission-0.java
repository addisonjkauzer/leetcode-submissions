class Solution {
    public int getSum(int a, int b) {
        Integer result = 0;
        Integer carryOver = 0;
        for (int i = 0; i < 32; i++) {
            Integer bitMask = 1 << i;
            int oneForA = (a & bitMask) != 0 ? 1 : 0;
            int oneForB = (b & bitMask) != 0 ? 1 : 0;
            int sum = oneForA + oneForB + carryOver;
            if (sum == 3) {
                result = result |= bitMask;
            }
            if (sum == 2) {
                carryOver = 1;
            }
            if (sum == 1) {
                result = result |= bitMask;
                carryOver = 0;
            }
        }
        if (result > 0x7FFFFFFF) {
            result = ~(result ^ 0xFFFFFFFF);
        }
        return result; 
    }
}
