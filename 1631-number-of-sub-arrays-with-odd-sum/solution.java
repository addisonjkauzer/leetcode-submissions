class Solution {
    public int numOfSubarrays(int[] arr) {
        Integer evenPrefixCounter = 0;
        Integer oddPrefixCounter = 0;
        Integer count = 0;
        Integer sum = 0;

        int MOD = (int)1e9 + 7;

        for (int num : arr) {
            sum += num;
            
            if (sum % 2 == 0) {
                count += oddPrefixCounter;
                evenPrefixCounter++;
            } else {
                count += (evenPrefixCounter + 1);
                oddPrefixCounter++;
            }
            count %= MOD;
        }
        return count;
    }
}