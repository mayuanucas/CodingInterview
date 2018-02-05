import java.util.Stack;

/**
 * @author mayuan
 * @desc
 * @date 2018/02/05
 */
public class Solution06 {

    public static void main(String[] args){
        test();
    }

    /**
     * 构造链表为： 0->1->2->3->4->5->null
     */
    public static void test() {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode root = new ListNode(0, node1);

        inversePrint(root);
    }

    /**
     * 输入个链表的头结点，从尾到头反过来打印出每个结点的值.
     * 使用栈的方式进行
     * @param root
     */
    public static void inversePrint(ListNode root){
        Stack<ListNode> stack = new Stack<>();

        while (null != root){
            stack.push(root);
            root = root.next;
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop().value + " ");
        }
        System.out.println();
    }

    /**
     * 节点对象
     */
    public static class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

}
