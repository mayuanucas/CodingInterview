package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/16
 */
public class Solution024 {
    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode p = temp;

        while (null != p.next && null != p.next.next) {
            ListNode t = p.next;
            p.next = t.next;
            t.next = p.next.next;
            p.next.next = t;
            p = t;
        }
        return temp.next;
    }
}