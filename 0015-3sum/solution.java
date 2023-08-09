class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        HashMap<Integer, Integer> finalNumberFinder = new HashMap();

        for(int i = 0; i < nums.length; i ++) {
            Integer count = finalNumberFinder.getOrDefault(nums[i], 0);
            count++;
            finalNumberFinder.put(nums[i], count);
        }
        Arrays.sort(nums);
        int iIndex = 0;
        int jIndex = 1;
        HashSet<List<Integer>> uniqueSolutionsSet = new HashSet();
        while (iIndex < nums.length - 2) {
            while (jIndex < nums.length -1) {
                int finalValue = 0 - nums[iIndex] - nums[jIndex];
                if (finalNumberFinder.containsKey(finalValue)) {
                    Integer count = finalNumberFinder.get(finalValue);
                    if(finalValue == nums[iIndex]) {
                        count--;
                    }
                    if(finalValue == nums[jIndex]) {
                        count--;
                    }
                    if (count > 0) {
                        ArrayList solution = new ArrayList();
                        solution.add(nums[iIndex]);
                        solution.add(nums[jIndex]);
                        solution.add(finalValue);
                        Collections.sort(solution);
                        uniqueSolutionsSet.add(solution);
                    }
                }
                int sum = nums[iIndex] + nums[jIndex];
                if (sum > 0) {
                    break;
                }
                jIndex++;
            }
            int sum = nums[iIndex];
            if (sum > 0) {
                break;
            }
            iIndex++;
            jIndex = iIndex + 1;
        }

        List<List<Integer>> finalSolution = new ArrayList<>(uniqueSolutionsSet);
        return finalSolution;
    }
}