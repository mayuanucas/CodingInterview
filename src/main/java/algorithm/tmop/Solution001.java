package algorithm.tmop;

/**
 * @author: mayuan
 * @desc:
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @date: 2018/11/19
 */
public class Solution001 {

    public static void main(String[] args) {
        final char[] array = {'a', 'b', 'c', 'd', 'e', 'f'};
        final int n = 3;

        for (char c : array) {
            System.out.print(c + " ");
        }
        System.out.println();

        leftRotateString(array, n);
        for (char c : array) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void leftRotateString(char[] array, int n) {
        // 如果向左移动大于 array.length, 则进行取余
        n %= array.length;

        reverseString(array, 0, n - 1);
        reverseString(array, n, array.length - 1);
        reverseString(array, 0, array.length - 1);
    }

    public static void reverseString(char[] array, int from, int to) {
        while (from < to) {
            char tmp = array[from];
            array[from] = array[to];
            array[to] = tmp;

            ++from;
            --to;
        }
    }
}
