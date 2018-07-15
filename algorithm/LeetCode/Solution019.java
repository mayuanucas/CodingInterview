/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/15
 */
public class Solution019 {
    /**
     * 1.我们要删除单链表中的一个元素（在不变动其值得情况下），我们只能是先找到它的前一个节点，然后重新连接。在这里为了防止删除的是正数第一个节点，所以我们有必要加一个临时的头结点temp。
     *
     * 2.采用快慢指针的思路，去定位倒数第n个节点。两个游标指针fast,slow。先让fast走n步，然后二者同时往下走。最终slow走到要删除节点的前一个元素，而fast走向NULL。
     *
     * 3.执行删除操作。返回temp->next.
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head || n < 1) {
            return null;
        }

        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode fast = head;
        ListNode slow = temp;
        for (int i = 0; i < n && null != fast; i++) {
            fast = fast.next;
        }
        while (null != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        // fast 指向需要删除的节点
        fast = slow.next;
        // 删除节点
        slow.next = fast.next;
        fast.next = null;
        return temp.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}