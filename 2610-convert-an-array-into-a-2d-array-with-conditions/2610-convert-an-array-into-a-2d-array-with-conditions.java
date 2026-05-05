class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> intCounter = new HashMap<>();
        for (int num : nums) {
            intCounter.put(num, intCounter.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();

        while (!intCounter.keySet().isEmpty()) {
            List<Integer> row = new ArrayList<>();
            Set<Integer> keySet = new HashSet<>(intCounter.keySet());
            for (int key : keySet) {
                row.add(key);
                int newValue = intCounter.get(key) - 1;
                if (newValue == 0) {
                    intCounter.remove(key);
                } else {
                    intCounter.put(key, newValue);
                }
            }
            result.add(row);
        }
        return result;
        
    }
}