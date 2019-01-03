package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 旋转链表
 * @date: 2019/01/03
 */
public class Solution061 {

    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || 0 > k) {
            return null;
        }

        // 获得链表的长度
        int cnt = 0;
        ListNode tmp = head;
        while (null != tmp) {
            ++cnt;
            tmp = tmp.next;
        }

        k %= cnt;
        if (0 == k) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; ++i) {
            fast = fast.next;
        }

        while (null != fast.next) {
            fast = fast.next;
            slow = slow.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
