package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 对称二叉树
 * @date: 2019/02/26
 */
public class Solution101 {

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (null == left || null == right) {
            return left == right;
        }

        if (left.val != right.val){
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
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
