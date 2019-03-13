package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 二叉树的右视图
 * @date: 2019/03/13
 */
public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (null == root) {
            return ans;
        }

        dfs(ans, root, 0);
        return ans;
    }

    public void dfs(List<Integer> answer, TreeNode node, int depth) {
        if (null == node) {
            return;
        }

        if (answer.size() == depth) {
            answer.add(node.val);
        }
        // 必须先右子树,因为右子树添加节点后左子树就无法添加节点
        dfs(answer, node.right, depth + 1);
        dfs(answer, node.left, depth + 1);
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
