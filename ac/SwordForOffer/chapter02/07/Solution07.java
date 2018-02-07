/**
 * @author mayuan
 * @desc
 * @date 2018/02/05
 */
public class Solution07 {

    public static void main(String[] args) {
        test();
    }

    /**
     *
     */
    public static void test() {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};

        BinaryTreeNode root = construct(preOrder, inOrder);
        System.out.println("前序遍历二叉树:");
        preorderTraversal(root);

        System.out.println("\n中序遍历二叉树:");
        inorderTraversal(root);

        System.out.println("\n后序遍历二叉树:");
        postorderTraversal(root);

    }

    /**
     * 前序遍历二叉树
     */
    public static void preorderTraversal(BinaryTreeNode root) {
        if (null != root) {
            System.out.print(root.value + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    /**
     * 中序遍历二叉树
     *
     * @param root
     */
    public static void inorderTraversal(BinaryTreeNode root) {
        if (null != root) {
            inorderTraversal(root.left);
            System.out.print(root.value + " ");
            inorderTraversal(root.right);
        }
    }

    /**
     * 后续遍历二叉树
     *
     * @param root
     * @return
     */
    public static void postorderTraversal(BinaryTreeNode root) {
        if (null != root) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }

    public static BinaryTreeNode construct(int[] preOrder, int[] inOrder) {
        if (null == preOrder || null == inOrder || preOrder.length != inOrder.length || 1 > preOrder.length) {
            return null;
        }

        return constructCore(preOrder, 0, preOrder.length - 1,
                inOrder, 0, inOrder.length - 1);
    }

    public static BinaryTreeNode constructCore(int[] preOrder, int startPreOrder, int endPreOrder,
                                               int[] inOrder, int startInOrder, int endInOrder) {
        if (startPreOrder > endPreOrder) {
            return null;
        }

        int value = preOrder[startPreOrder];
        int index = startInOrder;

        while (index <= endInOrder && inOrder[index] != value) {
            ++index;
        }

        if (index > endInOrder) {
            throw new RuntimeException("Invalid input");
        }

        BinaryTreeNode node = new BinaryTreeNode(value, null, null);
        node.left = constructCore(preOrder, startPreOrder + 1, startPreOrder + index - startInOrder,
                inOrder, startInOrder, index - 1);
        node.right = constructCore(preOrder, startPreOrder + index - startInOrder + 1, endPreOrder,
                inOrder, index + 1, endInOrder);

        return node;
    }

    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
