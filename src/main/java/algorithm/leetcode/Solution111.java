package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 二叉树的最小深度
 * @date: 2019/03/07
 */
public class Solution111 {

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int l = minDepth(root.left);
        int r = minDepth(root.right);

        if (0 == l || 0 == r) {
            return l + r + 1;
        } else {
            return Math.min(l, r) + 1;
        }
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
