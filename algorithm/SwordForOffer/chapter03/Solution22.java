/**
 * @author mayuan
 * @desc
 * @date 2018/03/01
 */
public class Solution22 {

    public static void main(String[] args) {
        ListNode end = new ListNode(9, null);
        ListNode node3 = new ListNode(6, end);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(0, node1);

        System.out.println(findKthToTail(head, 3).value);
    }

    public static ListNode findKthToTail(ListNode head, int k){
        if (null == head || 1 > k){
            return null;
        }
        ListNode left = head, right = head;
        while (null != right && k > 0){
            right = right.next;
            k--;
        }
        if (0 < k){
            return null;
        }
        while (null != right){
            right = right.next;
            left = left.next;
        }
        return left;
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