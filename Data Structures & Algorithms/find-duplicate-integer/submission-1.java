class Solution {
    public int findDuplicate(int[] nums) {
        Integer slow = nums[0];
        Integer fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        Integer slow2 = 0;

        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
        
    }
}
