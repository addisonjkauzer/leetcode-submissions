class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        result.add(Arrays.asList(1));
        if (numRows == 1) {
            return result;
        }
        result.add(Arrays.asList(1, 1));
        for (int i = 0; i < numRows - 2; i++) {
            List<Integer> newRow = new ArrayList<>();
            List<Integer> previousRow = result.get(result.size() - 1);

            newRow.add(1);
            for (int j = 0; j < previousRow.size() - 1; j++) {
                int left = previousRow.get(j);
                int right = previousRow.get(j + 1);
                newRow.add(left + right);
            }
            newRow.add(1);
            result.add(newRow);
        }
        return result;
    }
}