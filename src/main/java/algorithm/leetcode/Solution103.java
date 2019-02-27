package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 二叉树的锯齿形层次遍历
 * @date: 2019/02/27
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (null == root) {
            return ans;
        }

        levelOrder(ans, root, 0);
        return ans;
    }

    public void levelOrder(List<List<Integer>> answer, TreeNode node, int depth) {
        if (null == node) {
            return;
        }

        // 遍历到新的一层
        if (answer.size() <= depth) {
            answer.add(new LinkedList<>());
        }

        // 奇数层倒序(头插法)
        if (1 == (depth & 1)) {
            answer.get(depth).add(0, node.val);
        } else {
            answer.get(depth).add(node.val);
        }

        levelOrder(answer, node.left, depth + 1);
        levelOrder(answer, node.right, depth + 1);
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
