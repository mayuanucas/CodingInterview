package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 二叉搜索树结点最小距离
 * @date: 2019/03/02
 */
public class Solution783 {

    TreeNode pre;
    int mn = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return mn;
    }

    public void inOrder(TreeNode node) {
        if (null == node) {
            return;
        }

        inOrder(node.left);
        if (null != pre) {
            mn = Math.min(mn, node.val - pre.val);
        }
        // 遍历右子树时,pre引用需要更新为node
        pre = node;
        inOrder(node.right);
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
