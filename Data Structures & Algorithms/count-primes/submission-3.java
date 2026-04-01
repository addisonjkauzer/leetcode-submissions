class Solution {

    public int countPrimes(int n) {
        boolean[] sieve = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!sieve[i]) {
                count++;
                for (long j = i * 1L* i; j < n; j += i) {
                    sieve[(int)j] = true;
                }
            }
        }
        return count;
    }


}