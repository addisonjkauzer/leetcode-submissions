class Solution {
    public int reverseBits(int n) {
        Integer result = 0;
        for (int i = 0; i < 32; i++) {
            Integer bitmask = 1 << i;
            if ((bitmask & n) != 0) {
                Integer newBit = 1 << 31 - i;
                result += newBit;
            }
        }
        return result;
    }
}
