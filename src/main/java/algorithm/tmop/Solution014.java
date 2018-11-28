package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 荷兰国旗问题
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @date:
 */
public class Solution014 {

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 0, 0, 2, 1, 0};

        threeColorSort(array);

        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    /**
     * 设置两个标志位begin和end分别指向这个数组的开始和末尾，然后用一个标志位current从头开始进行遍历：
     * 1）若遍历到的位置为0，则说明它一定属于前部，于是就和begin位置进行交换，然后current向前进，
     * begin也向前进（表示前边的已经都排好了）。
     * 2）若遍历到的位置为1，则说明它一定属于中部，根据总思路，中部的我们都不动，然后current向前进。
     * 3）若遍历到的位置为2，则说明它一定属于后部，于是就和end位置进行交换，由于交换完毕后current指向的
     * 可能是属于前部的，若此时current前进则会导致该位置不能被交换到前部，所以此时current不前进，end则向后退1。
     *
     * @param array
     */
    public static void threeColorSort(int[] array) {
        if (null == array || 1 >= array.length) {
            return;
        }

        int begin = 0;
        int current = 0;
        int end = array.length - 1;

        while (current <= end) {
            if (0 == array[current]) {
                swap(array, current, begin);
                ++begin;
                ++current;
            } else if (1 == array[current]) {
                ++current;
            } else {
                swap(array, current, end);
                --end;
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
