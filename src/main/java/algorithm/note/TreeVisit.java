package algorithm.note;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: mayuan
 * @desc: 二叉树的遍历问题
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

        System.out.println("二叉树前序遍历");
        preOrder(node0);
        System.out.println();
        preOrder2(node0);
        System.out.println();

        System.out.println("二叉树中序遍历");
        inorderTraversal(node0);
        System.out.println();
        inorderTraversal2(node0);
        System.out.println();

        System.out.println("二叉树后序遍历");
        postTraversal(node0);
        System.out.println();
        postTraversal2(node0);
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

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            visit(cur);
            if (null != cur.right) {
                stack.push(cur.right);
            }
            if (null != cur.left) {
                stack.push(cur.left);
            }
        }
    }

    /**
     * 二叉树中序遍历
     *
     * @param root
     */
    public static void inorderTraversal(TreeNode root) {
        if (null == root) {
            return;
        }
        inorderTraversal(root.left);
        visit(root);
        inorderTraversal(root.right);
    }

    /**
     * 二叉树中序遍历(非递归)
     *
     * @param root
     */
    public static void inorderTraversal2(TreeNode root) {
        if (null == root) {
            return;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while (null != cur || !stack.isEmpty()) {
            while (null != cur) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            visit(cur);
            cur = cur.right;
        }
    }

    /**
     * 二叉树后序遍历
     *
     * @param root
     */
    public static void postTraversal(TreeNode root) {
        if (null == root) {
            return;
        }

        postTraversal(root.left);
        postTraversal(root.right);
        visit(root);
    }

    /**
     * 二叉树后序遍历(非递归)
     *
     * @param root
     */
    public static void postTraversal2(TreeNode root) {
        if (null == root) {
            return;
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
                visit(cur);
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
