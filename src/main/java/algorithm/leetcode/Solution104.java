package algorithm.leetcode;

import java.util.LinkedList;

/**
 * @author: mayuan
 * @desc: 二叉树的深度
 * @date: 2019/03/01
 */
public class Solution104 {

    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int depth = 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 记录当前层节点的数目
            int size = queue.size();
            while (size-- > 0) {
                TreeNode cur = queue.pollFirst();
                if (null != cur.left) {
                    queue.add(cur.left);
                }
                if (null != cur.right) {
                    queue.add(cur.right);
                }
            }
            ++depth;
        }
        return depth;
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
