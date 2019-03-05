package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: mayuan
 * @desc: 二叉树的中序遍历
 * @date: 2019/03/05
 */
public class Solution094 {

    /**
     * 非递归中序遍历二叉树
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();

        if (null == root) {
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (null != cur || !stack.isEmpty()) {
            while (null != cur) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();

        if (null == root) {
            return ans;
        }

        dfs(ans, root);
        return ans;
    }

    public void dfs(List<Integer> answer, TreeNode node) {
        if (null == node) {
            return;
        }

        dfs(answer, node.left);
        answer.add(node.val);
        dfs(answer, node.right);
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
