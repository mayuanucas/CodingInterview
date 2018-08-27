package SwordForOffer.chapter03;

/**
 * @author mayuan
 * @desc
 * @date 2018/03/01
 */
public class Solution26 {

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node7);
        BinaryTreeNode node9 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode node8 = new BinaryTreeNode(8, node9, node2);

        BinaryTreeNode mynode2 = new BinaryTreeNode(2, null, null);
        BinaryTreeNode mynode9 = new BinaryTreeNode(9, null, null);
        BinaryTreeNode mynode8 = new BinaryTreeNode(8, mynode9, mynode2);

        System.out.println(hasSubtree(node8, mynode8));
    }

    public static boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (null != root1 && null != root2) {
            if (equal(root1.value, root2.value)) {
                result = tree1HasTree2(root1, root2);
            }

            if (!result) {
                result = hasSubtree(root1.left, root2);
            }
            if (!result) {
                result = hasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public static boolean tree1HasTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (null == root2) {
            return true;
        }

        if (null == root1) {
            return false;
        }

        if (!equal(root1.value, root2.value)) {
            return false;
        }
        return tree1HasTree2(root1.left, root2.left) && tree1HasTree2(root1.right, root2.right);
    }

    public static boolean equal(double num1, double num2) {
        if ((-1e-7 < num1 - num2) && (num1 - num2 < 1e-7)) {
            return true;
        } else {
            return false;
        }
    }
}

class BinaryTreeNode {
    double value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(double value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}