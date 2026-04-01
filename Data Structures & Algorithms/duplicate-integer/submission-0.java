class Solution {
    public boolean hasDuplicate(int[] nums) {
        final Set<Integer> uniqueNumbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        System.out.println("here: " + uniqueNumbers.size());
        System.out.println("here2: " + nums.length);
        if (uniqueNumbers.size() == nums.length) {
            return false;
        }
        return true;
    }
}