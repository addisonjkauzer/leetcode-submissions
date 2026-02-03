class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            Integer sum = 0;
            for (int j = 1; j <= Math.abs(k); j++) {
                int increment = k >=0 ? j : j * -1;
                int mod = (((i + increment) % code.length) + code.length) % code.length;
                sum += code[mod];
            }
            result[i] = sum;
        }
        return result;
    }
}