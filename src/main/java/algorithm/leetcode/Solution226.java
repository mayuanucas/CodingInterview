package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 翻转二叉树
 * @date: 2019/03/05
 */
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
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
