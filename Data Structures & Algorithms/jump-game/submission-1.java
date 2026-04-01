class Solution {
    public boolean canJump(int[] nums) {
        Integer farthestJump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && farthestJump <= i) {
                return false;
            }
            farthestJump = Math.max(farthestJump, nums[i] + i);
            System.out.println(i);
            System.out.println(farthestJump);
        }
        return true;
    }
}
