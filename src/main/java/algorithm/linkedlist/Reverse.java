package algorithm.linkedlist;

/**
 * @author: mayuan
 * @desc: 反转单链表
 * @date: 2018/09/04
 */
public class Reverse {
    public static void main(String[] args) {
        Node node3 = new Node(3, null);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        Node node0 = new Node(0, node1);

        printLinkedList(node0);
        System.out.println();

        reverseLinkedList(node0);
        printLinkedList(node3);
        System.out.println();

    }

    public static void reverseLinkedList(Node head) {
        if (null == head) {
            return;
        }

        Node preNode = null;
        Node currentNode = head;
        Node nextNode = currentNode.next;

        while (null != currentNode) {
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
            if (null != currentNode) {
                nextNode = currentNode.next;
            }
        }
    }

    public static void printLinkedList(Node node) {
        Node cur = node;
        while (null != cur) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
    }

    static class Node {
        int value;
        Node next;

        Node(int v, Node n) {
            this.value = v;
            this.next = n;
        }

        @Override
        public String toString() {
            return this.value + " ";
        }
    }
}
