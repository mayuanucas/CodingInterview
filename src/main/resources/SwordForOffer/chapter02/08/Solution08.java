/**
 * @author mayuan
 * @desc
 * @date 2018/02/05
 */
public class Solution08 {

    public static void main(String[] args) {
        test();
    }

    /**
     *
     */
    public static void test() {
        BinaryTreeNode a = new BinaryTreeNode("a", null, null, null);
        BinaryTreeNode b = new BinaryTreeNode("b", null, null, null);
        BinaryTreeNode c = new BinaryTreeNode("c", null, null, null);
        BinaryTreeNode d = new BinaryTreeNode("d", null, null, null);
        BinaryTreeNode e = new BinaryTreeNode("e", null, null, null);
        BinaryTreeNode f = new BinaryTreeNode("f", null, null, null);
        BinaryTreeNode g = new BinaryTreeNode("g", null, null, null);
        BinaryTreeNode h = new BinaryTreeNode("h", null, null, null);
        BinaryTreeNode i = new BinaryTreeNode("i", null, null, null);

        a.left = b;
        a.right = c;
        a.parent = null;

        b.left = d;
        b.right = e;
        b.parent = a;

        c.left = f;
        c.right = g;
        c.parent = a;

        d.left = null;
        d.right = null;
        d.parent = b;

        e.left = h;
        e.right = i;
        e.parent = b;

        f.left = null;
        f.right = null;
        f.parent = c;

        g.left = null;
        g.right = null;
        g.parent = c;

        h.left = null;
        h.right = null;
        h.parent = e;

        i.left = null;
        i.right = null;
        i.parent = e;

        BinaryTreeNode temp = getNextNode(a);
        if (null != temp) {
            System.out.println("a -> " + temp.value);
        } else {
            System.out.println("a -> null");
        }

        temp = getNextNode(d);
        if (null != temp) {
            System.out.println("d -> " + temp.value);
        } else {
            System.out.println("d -> null");
        }

        temp = getNextNode(g);
        if (null != temp) {
            System.out.println("g -> " + temp.value);
        } else {
            System.out.println("g -> null");
        }

    }


    public static BinaryTreeNode getNextNode(BinaryTreeNode node) {
        if (null == node) {
            return null;
        }

        BinaryTreeNode pNext = null;

        if (null != node.right) {
            BinaryTreeNode pRight = node.right;
            while (null != pRight.left) {
                pRight = pRight.left;
            }
            pNext = pRight;
        } else if (null != node.parent) {
            BinaryTreeNode pCurrent = node;
            BinaryTreeNode pParent = node.parent;
            while (null != pParent && pCurrent == pParent.right) {
                pCurrent = pParent;
                pParent = pParent.parent;
            }
            pNext = pParent;
        }

        return pNext;
    }

    public static class BinaryTreeNode {
        String value;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode parent;

        public BinaryTreeNode(String value, BinaryTreeNode left, BinaryTreeNode right, BinaryTreeNode parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
}
