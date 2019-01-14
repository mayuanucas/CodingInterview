package algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/16
 */
public class Solution257 {
    public static void main(String[] args) {

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new LinkedList<>();

        if (null == root) {
            return answer;
        }

//        dfs(answer, "", root);
        List<Integer> values = new ArrayList<>(128);
        dfs2(answer, values, root);
        return answer;
    }

    private void dfs(List<String> answer, String oneAnswer, TreeNode node) {
        // 当前节点是叶节点,添加后返回即可.
        if (null == node.left && null == node.right) {
            answer.add(oneAnswer + node.val);
            return;
        }

        // 依次迭代该节点的子节点
        for (TreeNode t : new TreeNode[]{node.left, node.right}) {
            if (null == t) {
                continue;
            }

            dfs(answer, oneAnswer + node.val + "->", t);
        }
    }

    private void dfs2(List<String> answer, List<Integer> values, TreeNode node) {
        if (null == node) {
            return;
        }

        values.add(node.val);
        if (isLeaf(node)) {
            answer.add(buildPath(values));
        } else {
            dfs2(answer, values, node.left);
            dfs2(answer, values, node.right);
        }
        values.remove(values.size() - 1);
    }

    private boolean isLeaf(TreeNode node) {
        if (null == node) {
            return false;
        }

        return null == node.left && null == node.right;
    }

    private String buildPath(List<Integer> values) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < values.size(); ++i) {
            stringBuilder.append(values.get(i));
            if (values.size() - 1 != i) {
                stringBuilder.append("->");
            }
        }
        return stringBuilder.toString();
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }
}