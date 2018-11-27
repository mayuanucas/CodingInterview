package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 奇偶数排序
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @date:
 */
public class Solution013 {

    public static void main(String[] args) {
        int[] array = {10, 7, 12, 1, 3, 6, 5};

        oddEvenSort(array);

        for (int n : array) {
            System.out.print(n + " ");
        }
    }

    /**
     * 借鉴快速排序中用轴(pivot)划分数组的思想
     *
     * @param array
     */
    public static void oddEvenSort(int[] array) {
        if (null == array || 1 >= array.length) {
            return;
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && isOdd(array[left])) {
                ++left;
            }
            while (left < right && !isOdd(array[right])) {
                --right;
            }

            swap(array, left, right);
        }
    }

    /**
     * 判断是否为奇数
     *
     * @param number
     * @return
     */
    public static boolean isOdd(int number) {
        return 1 == (number & 1);
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
