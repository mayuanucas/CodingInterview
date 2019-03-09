package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 求根到叶子节点数字之和
 * @date: 2019/03/09
 */
public class Solution129 {

    public int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int sum) {
        if (null == node) {
            return 0;
        }

        int curNumber = sum * 10 + node.val;
        // 当前节点为叶子节点
        if (null == node.left && null == node.right) {
            return curNumber;
        } else {
            // 非叶子节点
            return dfs(node.left, curNumber) + dfs(node.right, curNumber);
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
