class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        String currentParens = "";

        generateParens(currentParens, results, n, 0);
        return results;
    }


    public void generateParens(String currentParens, List<String> results, int remainingOpen, int remainingClosed) {
        if (remainingClosed == 0 && remainingOpen == 0 && currentParens.length() > 0) {
            results.add(currentParens);
        }
        if (remainingOpen > 0) {
            generateParens(currentParens + "(", results, remainingOpen - 1, remainingClosed + 1);
        }
        if (remainingClosed > 0) {
            generateParens(currentParens + ")", results, remainingOpen, remainingClosed - 1);
        }
        return;


    }
}
