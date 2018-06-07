/**
 * @author mayuan
 * @desc
 * @date 2018/03/01
 */
public class Solution18_2 {

    public static void main(String[] args) {
        ListNode end = new ListNode(9, null);
        ListNode node3 = new ListNode(6, end);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(0, node1);

        deleteDuplication(head);
        while (null != head) {
            System.out.print(head.value);
            if (null != head.next) {
                System.out.print("->");
            }
            head = head.next;
        }
    }

    public static ListNode deleteDuplication(ListNode head) {
        if (null == head) {
            return null;
        }
        if (null == head.next) {
            return head;
        }
        if (head.value == head.next.value) {
            ListNode next = head.next;
            while (null != next && head.value == next.value) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            head.next = deleteDuplication(head.next);
            return head;
        }
    }

}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}