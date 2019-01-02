package algorithm.leetcode;

/**
 * @author mayuan
 * @desc 两数相加
 * 时间复杂度: O(n) 或 O(m) n,m为两个链表的长度,取最大的
 * 空间复杂度: O(1)
 * @date 2018/02/07
 */
public class Solution002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, current = head;
        int carry = 0;

        while (null != p || null != q) {
            int x = (null != p) ? p.val : 0;
            int y = (null != q) ? q.val : 0;
            int sum = carry + x + y;

            if (10 <= sum) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }

            current.next = new ListNode(sum);
            current = current.next;

            if (null != p) {
                p = p.next;
            }
            if (null != q) {
                q = q.next;
            }
        }

        // 最后一步仍然需要进位
        if (0 < carry) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
