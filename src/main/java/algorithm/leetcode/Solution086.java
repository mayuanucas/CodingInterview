package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 分隔链表
 * @date: 2019/01/03
 */
public class Solution086 {

    public ListNode partition(ListNode head, int x) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);
        ListNode p1 = node1, p2 = node2;

        while (null != head) {
            if (x > head.val) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }

        p2.next = null;
        p1.next = node2.next;
        return node1.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
