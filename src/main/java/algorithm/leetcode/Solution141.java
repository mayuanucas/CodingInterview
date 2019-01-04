package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 环形链表
 * @date: 2019/01/04
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }

        ListNode slow = head, fast = head;
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
