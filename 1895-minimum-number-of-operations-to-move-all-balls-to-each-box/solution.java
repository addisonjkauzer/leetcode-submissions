class Solution {
    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];

        int totalBoxes = 0;
        int operations = 0;
        for (int i = 0; i < boxes.length(); i++) {
            char ch = boxes.charAt(i);
                        operations += totalBoxes;
            result[i] = operations;
            if (ch == '1') {
                totalBoxes += 1;
            }
        }
        totalBoxes = 0;
        operations = 0;
        for (int i = boxes.length() - 1; i >= 0; i--) {
            char ch = boxes.charAt(i);
            operations += totalBoxes;
            result[i] += operations;
            if (ch == '1') {
                totalBoxes += 1;
            }
        }
        return result;
    }
}