package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 二叉树的层次遍历 II
 * @date: 2019/03/07
 */
public class Solution107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == root) {
            return ans;
        }

        dfs(ans, root, 0);
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(List<List<Integer>> answer, TreeNode node, int depth) {
        if (null == node) {
            return;
        }

        if (answer.size() <= depth) {
            answer.add(new LinkedList<>());
        }
        answer.get(depth).add(node.val);

        dfs(answer, node.left, depth + 1);
        dfs(answer, node.right, depth + 1);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
