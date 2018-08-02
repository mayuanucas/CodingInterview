package algorithm.leetcode;

/**
 * @author mayuan
 * @desc
 * @date 2018/02/08
 */
public class Solution021 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1){
            return l2;
        }
        if (null == l2){
            return l1;
        }

        ListNode tempL1 = l1, tempL2 = l2;
        ListNode root = new ListNode(0);
        ListNode current = root;

        while (null != tempL1 && null != tempL2) {
            if (tempL1.val < tempL2.val) {
                current.next = new ListNode(tempL1.val);
                tempL1 = tempL1.next;
            } else {
                current.next = new ListNode(tempL2.val);
                tempL2 = tempL2.next;
            }
            current = current.next;
        }

        if (null == tempL1) {
            current.next = tempL2;
        }

        if (null == tempL2) {
            current.next = tempL1;
        }

        return root.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
