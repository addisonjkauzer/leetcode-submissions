class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer, Stack<Integer>> nums2Mapping = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            Stack<Integer> existingIndexes = nums2Mapping.getOrDefault(nums2[i], new Stack<>());
            existingIndexes.add(i);
            nums2Mapping.put(nums2[i], existingIndexes);
        }
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            Integer itemLookingFor = nums1[i];
            Integer indexIn2 = nums2Mapping.get(itemLookingFor).pop();
            result[i] = indexIn2;
        }
        return result;
    }
}
