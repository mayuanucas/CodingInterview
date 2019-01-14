package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 排序链表: 折半归并排序
 * @date: 2019/01/14
 */
public class Solution148 {

    public ListNode sortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode slow = head, fast = head, pre = null;
        while (null != fast && null != fast.next) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        ListNode l = sortList(head);
        ListNode r = sortList(slow);
        return merge(l, r);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
