/**
 * @author mayuan
 * @desc
 * @date 2018/03/02
 */
public class Solution25 {

    public static void main(String[] args) {
        ListNode node7 = new ListNode(7, null);
        ListNode node5 = new ListNode(5, node7);
        ListNode node3 = new ListNode(3, node5);
        ListNode node1 = new ListNode(1, node3);
        ListNode node8 = new ListNode(8, null);
        ListNode node6 = new ListNode(6, node8);
        ListNode node4 = new ListNode(4, node6);
        ListNode node2 = new ListNode(2, node4);

        ListNode temp = merge(node1, node2);
        while (null != temp) {
            System.out.print(temp.value);
            if (null != temp.next) {
                System.out.print("->");
            }
            temp = temp.next;
        }
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        if (null == head1) {
            return head2;
        } else if (null == head2) {
            return head1;
        }

        ListNode mergedHead = null;
        if (head1.value < head2.value) {
            mergedHead = head1;
            mergedHead.next = merge(head1.next, head2);
        } else {
            mergedHead = head2;
            mergedHead.next = merge(head1, head2.next);
        }
        return mergedHead;
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