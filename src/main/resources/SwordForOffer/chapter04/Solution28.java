/**
 * @author mayuan
 * @desc
 * @date 2018/03/03
 */
public class Solution28 {

    public static void main(String[] args) {
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node10 = new BinaryTreeNode(10, null, null);
        BinaryTreeNode node8 = new BinaryTreeNode(8, node6, node10);

        System.out.println(isSymmetrical(node8));
    }

    public static boolean isSymmetrical(BinaryTreeNode root) {
        return isSymmetrical(root, root);
    }

    public static boolean isSymmetrical(BinaryTreeNode node1, BinaryTreeNode node2) {
        if (null == node1 && null == node2) {
            return true;
        }
        if (null == node1 || null == node2) {
            return false;
        }

        if (node1.value != node2.value) {
            return false;
        }
        return isSymmetrical(node1.left, node2.right) && isSymmetrical(node1.right, node2.left);
    }
}

class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}