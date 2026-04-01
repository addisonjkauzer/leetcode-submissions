class Solution {
    public int hammingWeight(int n) {
        Integer result = 0;
        for (int i = 0; i < 32; i++) {
            Integer bitMask = 1 << i;
            if ((bitMask & n) != 0) {
                result++;
            }
        }
        return result;
    }
}
