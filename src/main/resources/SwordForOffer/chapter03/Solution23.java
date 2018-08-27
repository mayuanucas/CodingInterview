package SwordForOffer.chapter03;

/**
 * @author mayuan
 * @desc
 * @date 2018/03/01
 */
public class Solution23 {

    public static void main(String[] args) {
        ListNode end = new ListNode(6, null);
        ListNode node6 = new ListNode(6, null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node6.next = node3;

        System.out.println(entryNode(node1).value);

    }

    public static ListNode meetingNode(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (null != fast && null != slow) {
            if (fast == slow) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
            if (null != fast) {
                fast = fast.next;
            }
        }
        return null;
    }

    public static ListNode entryNode(ListNode head) {
        ListNode meetingNode = meetingNode(head);
        if (null == meetingNode) {
            return null;
        }
        int nodeNumber = 1;
        ListNode node1 = meetingNode;
        while (node1.next != meetingNode) {
            node1 = node1.next;
            nodeNumber++;
        }

        node1 = head;
        for (int i = 0; i < nodeNumber; i++) {
            node1 = node1.next;
        }

        ListNode node2 = head;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
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