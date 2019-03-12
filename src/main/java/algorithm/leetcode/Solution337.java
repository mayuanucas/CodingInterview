package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 打家劫舍 III
 * @date: 2019/03/12
 */
public class Solution337 {
    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] dfs(TreeNode node) {
        if (null == node) {
            return new int[2];
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] ans = new int[2];
        // ans[0] 表示不抢劫该节点,则可获得的最大收益为,左子树和右子树的最大收益之和
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // ans[1] 表示抢劫该节点,则可获得的最大收益为,不可抢直接相邻的左子树和右子树节点的收益之和
        ans[1] = node.val + left[0] + right[0];
        return ans;
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
