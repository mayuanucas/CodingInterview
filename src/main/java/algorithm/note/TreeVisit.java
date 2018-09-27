package algorithm.note;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: mayuan
 * @desc:  二叉树的遍历问题
 * @date: 2018/09/03
 */
public class TreeVisit {

    public static void main(String[] args) {
        /**
         *              0
         *         1         2
         *      3    4    5      6
         */
        TreeNode node6 = new TreeNode(null, 6, null);
        TreeNode node5 = new TreeNode(null, 5, null);
        TreeNode node4 = new TreeNode(null, 4, null);
        TreeNode node3 = new TreeNode(null, 3, null);
        TreeNode node2 = new TreeNode(node5, 2, node6);
        TreeNode node1 = new TreeNode(node3, 1, node4);
        TreeNode node0 = new TreeNode(node1, 0, node2);

        preOrder2(node0);
        System.out.println();

        levelTraversal(node0);
        System.out.println();

    }

    /**
     * 二叉树 前序遍历(递归)
     *
     * @param node
     */
    public static void preOrder(TreeNode node) {
        if (null == node) {
            return;
        }

        visit(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二叉树 前序遍历(非递归)
     *
     * @param node
     */
    public static void preOrder2(TreeNode node) {
        if (null == node) {
            return;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(node);

        while (!deque.isEmpty()) {
            TreeNode current = deque.pollLast();
            visit(current);
            if (null != current.right) {
                deque.offerLast(current.right);
            }
            if (null != current.left) {
                deque.offerLast(current.left);
            }
        }
    }

    /**
     * 二叉树的层次遍历
     *
     * @param node
     */
    public static void levelTraversal(TreeNode node) {
        if (null == node) {
            return;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(node);

        while (!deque.isEmpty()) {
            TreeNode current = deque.pollFirst();
            visit(current);
            if (null != current.left) {
                deque.offerLast(current.left);
            }
            if (null != current.right) {
                deque.offerLast(current.right);
            }
        }
    }


    public static void visit(TreeNode node) {
        System.out.print(node.val + " ");
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(TreeNode l, int v, TreeNode r) {
            this.left = l;
            this.right = r;
            this.val = v;
        }

        @Override
        public String toString() {
            return "val: " + val;
        }
    }
}
