package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 环形链表 II
 * @date: 2019/01/04
 */
public class Solution142 {

    public ListNode detectCycle(ListNode head) {
        if (null == head) {
            return null;
        }

        boolean isCycle = false;
        ListNode slow = head, fast = head;
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
