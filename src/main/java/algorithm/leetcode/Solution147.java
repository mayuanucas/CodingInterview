package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 对链表进行插入排序
 * @date: 2019/01/14
 */
public class Solution147 {

    public ListNode insertionSortList(ListNode head) {
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

        ListNode l = insertionSortList(head);
        ListNode r = insertionSortList(slow);
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

    public ListNode insertionSortList2(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode minHead = new ListNode(Integer.MIN_VALUE);
        ListNode p = head, q = minHead;
        while (true) {
            if (null != q.next && q.val <= p.val && q.next.val <= p.val) {
                q = q.next;
            } else {
                ListNode node = new ListNode(p.val);
                node.next = q.next;
                q.next = node;

                q = minHead;
                p = p.next;
                if (null == p) {
                    break;
                }
            }
        }
        return minHead.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
