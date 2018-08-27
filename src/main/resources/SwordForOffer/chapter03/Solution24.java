package SwordForOffer.chapter03;

/**
 * @author mayuan
 * @desc
 * @date 2018/03/01
 */
public class Solution24 {

    public static void main(String[] args) {
        ListNode end = new ListNode(5, null);
        ListNode node3 = new ListNode(3, end);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(0, node1);

        ListNode temp = reverseList(head);
        while (null != temp) {
            System.out.print(temp.value);
            if (null != temp.next) {
                System.out.print("->");
            }
            temp = temp.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode preNode = null, currentNode = head, nextNode = head.next;

        while (null != currentNode) {
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;
            if (null != nextNode) {
                nextNode = nextNode.next;
            }
        }
        return preNode;
    }

}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}