/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    ArrayList<Integer> solutions = new ArrayList();
    public int maxPathSum(TreeNode root) {
        solutions.add(maxPathSumChild(root));
        Integer max = solutions.get(0);
        for (Integer solution : solutions) {
            if (solution > max) {
                max = solution;
            }
        }
        return max;
    }

    private int maxPathSumChild(TreeNode root) {
        if (root == null) {
            return 0;
        }
        System.out.println(root.val);
        if (root.left == null && root.right == null) {
            return root.val;
        }
        if (root.left == null) {
            int maxPathSumRight = maxPathSumChild(root.right);
            solutions.add(maxPathSumRight);
            return Math.max(maxPathSumRight  + root.val, root.val); 
        }

        if (root.right == null) {
            int maxPathSumLeft = maxPathSumChild(root.left);
            solutions.add(maxPathSumLeft);
            return Math.max(maxPathSumLeft  + root.val, root.val);
        }

        int maxPathSumLeft = maxPathSumChild(root.left);
        int maxPathSumRight = maxPathSumChild(root.right);

        if (root.val >= 0) {
            if (maxPathSumLeft >= 0 && maxPathSumRight >= 0) {
                solutions.add(maxPathSumLeft + maxPathSumRight + root.val);
                return Math.max(maxPathSumLeft, maxPathSumRight) + root.val;
            }
            if (maxPathSumLeft >= 0) {
                return maxPathSumLeft + root.val;
            }
            if (maxPathSumRight >= 0) {
                return maxPathSumRight + root.val;
            }
            return root.val;
        } else {
            int maxOfChildren = Math.max(maxPathSumLeft, maxPathSumRight);
            System.out.println("Sum: " + maxPathSumLeft + maxPathSumRight + root.val);
            solutions.add(maxOfChildren);
            solutions.add(root.val + maxPathSumLeft + maxPathSumRight);
            return Math.max(root.val, root.val + maxOfChildren);
        }  
    }
}