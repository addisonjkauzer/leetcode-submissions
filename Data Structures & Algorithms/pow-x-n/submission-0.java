class Solution {
    public double myPow(double x, int n) {
        Double myPow = 1.0;
        for (int i = 0; i < n; i++) {
            myPow *= x;
        }
        for (int i = 0; i > n; i--) {
            myPow *= x;
        }
        if (n >= 0) {
            return myPow;
        }
        return 1.0 / myPow;
    }
}
