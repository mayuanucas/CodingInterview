package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 验证二叉搜索树
 * @date: 2019/02/19
 */
public class Solution098 {

    /**
     * 二叉搜索树的中序遍历序列是递增的
     * 左子树的所有节点值都小于该节点
     * 右子树的所有节点值都大于该节点
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }

        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        for (int i = 1; i < ans.size(); ++i) {
            if (ans.get(i - 1) >= ans.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void inOrder(TreeNode node, List<Integer> result) {
        if (null == node) {
            return;
        }

        inOrder(node.left, result);
        result.add(node.val);
        inOrder(node.right, result);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
