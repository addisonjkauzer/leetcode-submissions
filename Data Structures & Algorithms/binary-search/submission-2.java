class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1 && nums[0] != target) {
            return -1;
        }

        if (target > nums[nums.length/2]) {
            final Integer index =  this.search(Arrays.copyOfRange(nums, nums.length/2, nums.length), target);
            if (index == -1) {
                return index;
            } else {
                return index + nums.length/2;
            }
        } else if (target < nums[nums.length/2]) {
            return this.search(Arrays.copyOfRange(nums, 0, nums.length/2), target);
        } else {
            return nums.length/2;
        }
        
    }
}
