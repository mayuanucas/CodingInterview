package algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 路径总和 II
 * @date: 2019/03/09
 */
public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> oneAns = new ArrayList<>();

        dfs(ans, oneAns, root, sum);
        return ans;
    }

    public void dfs(List<List<Integer>> answer, List<Integer> oneAnser, TreeNode node, int num) {
        if (null == node) {
            return;
        }

        oneAnser.add(node.val);

        if (null == node.left && null == node.right && num == node.val) {
            answer.add(new ArrayList<>(oneAnser));
        } else {
            dfs(answer, oneAnser, node.left, num - node.val);
            dfs(answer, oneAnser, node.right, num - node.val);
        }

        oneAnser.remove(oneAnser.size() - 1);
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
