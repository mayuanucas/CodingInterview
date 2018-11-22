package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/11/22
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        head = head.next;

        while (null != cur) {
            cur.next = pre;

            pre = cur;
            cur = head;
            if (null != head){
                head = head.next;
            }
        }

        return pre;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
