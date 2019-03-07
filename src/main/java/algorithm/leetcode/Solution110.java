package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:  平衡二叉树
 * @date: 2019/03/07
 */
public class Solution110 {

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    public int dfs(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int leftHeight = dfs(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = dfs(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
