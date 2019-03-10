package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 左叶子之和
 * @date: 2019/03/10
 */
public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (null == root){
            return 0;
        }

        return dfs(root.left, true) + dfs(root.right, false);
    }

    private int dfs(TreeNode node, boolean isLeft) {
        if (null == node) {
            return 0;
        }

        if (null == node.left && null == node.right && isLeft) {
            return node.val;
        } else {
            return dfs(node.left, true) + dfs(node.right, false);
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
