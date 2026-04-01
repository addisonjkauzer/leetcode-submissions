class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, new int[]{0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean helper(int[] preorder, int[] i, int minValue, int maxValue) {
        if (i[0] == preorder.length) {
            return true;
        }
        int root = preorder[i[0]];

        if (root <= minValue || root >= maxValue) {
            return false;
        }
        i[0]++;
        boolean left = helper(preorder, i, minValue, root);
        boolean right = helper(preorder, i, root, maxValue);
        return left || right;
    }
}
