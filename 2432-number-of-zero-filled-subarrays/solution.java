class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long occurances = 0;
        long run = 0;
        for (int num : nums) {
            if (num == 0) {
                occurances += 1;
                occurances += run;
                run++;
            } else {
                run = 0;
            }
        }
        return occurances;
        
    }
}