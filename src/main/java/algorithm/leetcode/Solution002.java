package algorithm.leetcode;

/**
 * @author mayuan
 * @desc
 * @date 2018/02/07
 */
public class Solution002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tempL1 = l1, tempL2 = l2, current = head;
        int carry = 0;

        while (null != tempL1 || null != tempL2) {
            int x = (null != tempL1) ? tempL1.val : 0;
            int y = (null != tempL2) ? tempL2.val : 0;
            int sum = carry + x + y;

            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (null != tempL1){
                tempL1 = tempL1.next;
            }
            if (null != tempL2){
                tempL2 = tempL2.next;
            }
        }

        // 最后一步仍然需要进位
        if (0 < carry) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
