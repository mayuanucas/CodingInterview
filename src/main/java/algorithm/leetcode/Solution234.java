package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 判断链表是否为回文字符串
 * @date: 2018/10/31
 */
public class Solution234 {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(1, null);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        boolean flag = isPalindrome(node1);
        System.out.println(flag);
    }

    /**
     * 一个快指针每次走2步,一个慢指针每次走1步(并反转走过的元素).找到中间位置,指针再向两边走,判断是否为回文字符串.
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (null == head) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (null != fast && null != fast.next) {
            fast = fast.next.next;

            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        // fast 指向第奇数个节点( fast不为null表示此时字符串长度为奇数)
        // 则此时中间位置的字符不用参与比较
        if (null != fast) {
            slow = slow.next;
        }

        // prev 指向左半侧字符串
        // slow 指向右半侧字符串
        while (null != slow) {
            if (prev.val != slow.val) {
                return false;
            }
            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }
}
