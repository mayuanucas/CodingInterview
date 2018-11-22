package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 判断单链表是否为回文
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @date:
 */
public class Solution007 {

    public static void main(String[] args) {
        ListNode node7 = new ListNode(1, null);
        ListNode node6 = new ListNode(2, node7);
        ListNode node5 = new ListNode(3, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        printList(node1);

        System.out.println(isPalindrome(node1));
    }

    public static void printList(ListNode head) {
        while (null != head) {
            System.out.print(head.val);
            if (null != head.next) {
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 1. 先扫描一遍链表取得链表的长度,从而可确定链表中间节点的位置.(链表长度 / 2)
     * 2. 让head指针指向链表的后半段起始位置,在向中间位置移动过程中对链表的前半部分进行反转.
     * 3. 反转过程中cur指针指向前半段的起始位置.
     * 4. 根据链表长度为奇数或偶数进行调整后,开始判断链表是否为回文链表.
     */
    public static boolean isPalindrome(ListNode head) {
        if (null == head) {
            return true;
        }

        int lengthOfList = 0;
        ListNode tmp = head;
        while (null != tmp) {
            ++lengthOfList;
            tmp = tmp.next;
        }

        // 单链表仅有1个节点,需要单独判断
        if (1 == lengthOfList) {
            return true;
        }

        int step = lengthOfList / 2;
        ListNode pre = null;
        ListNode cur = head;
        head = head.next;

        // 完成对单链表的前半段的反转,此时 pre 指向前半段的起始位置, cur 指向后半段的起始位置
        for (int i = 0; i < step; ++i) {
            cur.next = pre;

            pre = cur;
            cur = head;
            if (null != head) {
                head = head.next;
            }
        }

        // 根据单链表的长度进行调整:如果单链表长度为奇数, cur指针需要向后再走1步
        if (1 == (lengthOfList & 1)) {
            cur = cur.next;
        }

        while (null != pre && null != cur) {
            if (pre.val != cur.val) {
                return false;
            }

            pre = pre.next;
            cur = cur.next;
        }

        return true;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode n) {
            val = x;
            this.next = n;
        }
    }

}
