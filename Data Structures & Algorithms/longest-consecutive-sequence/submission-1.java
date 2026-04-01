class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        final Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Integer longestConsecutiveLength = 1;

        for (Integer num : nums) {
            final Boolean isSequenceStarter = numsSet.contains(num -1);
            if (isSequenceStarter) {
                Integer lengthCounter = 1;
                while (numsSet.contains(num++)) {
                    lengthCounter++;
                }
                longestConsecutiveLength = Collections.max(Arrays.asList(longestConsecutiveLength, lengthCounter));
            }
        }

        return longestConsecutiveLength;
    }
}
