package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/17
 */
public class Solution144 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (null != fast && null != fast.next && null != slow) {
            if (slow == fast) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
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