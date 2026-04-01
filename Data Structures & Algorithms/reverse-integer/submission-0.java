class Solution {
    public int reverse(int x) {
        long result = reverse(Math.abs(x), 0) * (x < 0 ? -1 : 1);
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public long reverse(int x, long result) {
        if (x == 0) {
            return result;
        }
        result = result * 10 + x % 10;
        return reverse(x / 10, result);
    }
}
