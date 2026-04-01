class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int k = 0; k <= n; k++) {
            Integer kResult = 0;
            for (int i = 0; i < 32; i++) {
                Integer bitmask = 1 << i;
                if ((bitmask & k) != 0) {
                    kResult++;
                }
            }
            result[k] = kResult;
        }
        return result;
    }
}
