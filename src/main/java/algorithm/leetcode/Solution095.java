package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 不同的二叉搜索树 II
 * @date: 2019/02/19
 */
public class Solution095 {

    public List<TreeNode> generateTrees(int n) {
        if (0>=n){
            return new ArrayList<>();
        }
        return dfs(1, n);
    }

    public List<TreeNode> dfs(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();

        if (start > end) {
            ans.add(null);
            return ans;
        }
        if (start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }

        List<TreeNode> left = null, right = null;
        for (int i = start; i <= end; ++i) {
            left = dfs(start, i - 1);
            right = dfs(i + 1, end);

            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    ans.add(root);
                }
            }
        }
        return ans;
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
