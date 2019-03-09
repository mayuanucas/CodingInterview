package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 二叉树的后序遍历
 * @date: 2019/03/09
 */
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (null == root) {
            return ans;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        // cur:当前访问节点
        TreeNode cur = root;
        // pLastVisit:上次访问节点
        TreeNode pLastVisit = null;

        // 先移动到最左子树下,过程中压入栈
        while (null != cur) {
            stack.push(cur);
            cur = cur.left;
        }

        while (!stack.isEmpty()) {
            cur = stack.pop();
            //访问根节点的前提是：无右子树或右子树已被访问过
            if (null == cur.right || pLastVisit == cur.right) {
                ans.add(cur.val);
                pLastVisit = cur;
            } else {
                // 根节点再次入栈
                stack.push(cur);
                // 进入右子树，且可肯定右子树一定不为空
                cur = cur.right;
                while (null != cur) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        return ans;
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
