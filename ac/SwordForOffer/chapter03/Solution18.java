/**
 * @author mayuan
 * @desc
 * @date 2018/03/01
 */
public class Solution18 {

    public static void main(String[] args) {
        ListNode end = new ListNode(9, null);
        ListNode node3 = new ListNode(6, end);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(0, node1);

        deleteNode(head, node3);
        while (null != head) {
            System.out.print(head.value);
            if (null != head.next){
                System.out.print("->");
            }
            head = head.next;
        }
    }


    public static void deleteNode(ListNode head, ListNode toBeDelete) {
        if (null == head || null == toBeDelete) {
            return;
        }

        if (null != toBeDelete.next) {
            ListNode nextNode = toBeDelete.next;
            toBeDelete.value = nextNode.value;
            toBeDelete.next = nextNode.next;

            nextNode.next = null;
            nextNode = null;
        } else if (head == toBeDelete) {
            head = null;
            toBeDelete = null;
        } else {
            ListNode nextNode = head;
            while (nextNode.next != toBeDelete) {
                nextNode = nextNode.next;
            }
            nextNode.next = null;
            toBeDelete = null;
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