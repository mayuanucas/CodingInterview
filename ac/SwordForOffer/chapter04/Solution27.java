/**
 * @author mayuan
 * @desc
 * @date 2018/03/03
 */
public class Solution27 {

    public static void main(String[] args) {
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node10 = new BinaryTreeNode(10, null, null);
        BinaryTreeNode node8 = new BinaryTreeNode(8, node6, node10);

        mirrorRecursively(node8);
        System.out.println(node8);
    }

    public static void mirrorRecursively(BinaryTreeNode root) {
        if (null == root) {
            return;
        }
        if (null == root.left && null == root.right) {
            return;
        }

        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (null != root.left) {
            mirrorRecursively(root.left);
        }
        if (null != root.right) {
            mirrorRecursively(root.right);
        }
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