package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 二叉搜索树的范围和
 * @date: 2019/03/02
 */
public class Solution938 {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (null == root) {
            return 0;
        }

        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        } else {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
