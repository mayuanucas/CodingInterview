package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 找树左下角的值
 * @date: 2019/03/15
 */
public class Solution513 {
    int ans = 0;
    int curDepth = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    public void dfs(TreeNode node, int depth) {
        if (curDepth < depth) {
            ans = node.val;
            curDepth = depth;
        }

        if (null != node.left) {
            dfs(node.left, depth + 1);
        }
        if (null != node.right) {
            dfs(node.right, depth + 1);
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
