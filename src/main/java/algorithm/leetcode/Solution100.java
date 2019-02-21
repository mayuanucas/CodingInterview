package algorithm.leetcode;

import java.util.LinkedList;

/**
 * @author: mayuan
 * @desc: 相同的树
 * @date: 2019/02/21
 */
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    /**
     * 非递归解法
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            TreeNode a = queue.pollFirst();
            TreeNode b = queue.pollFirst();

            // 遍历到叶子节点
            if (null == a && null == b) {
                continue;
            } else if (null == a || null == b) {
                return false;
            } else {
                if (a.val != b.val) {
                    return false;
                } else {
                    queue.addLast(a.left);
                    queue.addLast(b.left);
                    queue.addLast(a.right);
                    queue.addLast(b.right);
                }
            }
        }
        return true;
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
