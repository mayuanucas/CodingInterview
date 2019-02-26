package algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 二叉树的层次遍历
 * @date: 2019/02/26
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

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

        // 遍历到当前层的第一个节点
        if (answer.size() <= depth) {
            answer.add(new LinkedList<>());
        }
        answer.get(depth).add(node.val);
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
