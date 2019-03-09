package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 路径总和
 * @date: 2019/03/09
 */
public class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }

        if (null == root.left && null == root.right && sum == root.val) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
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
