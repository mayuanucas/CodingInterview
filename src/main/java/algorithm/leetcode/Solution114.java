package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 二叉树展开为链表
 * @date: 2019/03/09
 */
public class Solution114 {

    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
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
