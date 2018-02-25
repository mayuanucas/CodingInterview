/**
 * @author mayuan
 * @desc 冒泡排序
 *
 * 时间复杂度
 * 最坏: O(n^2)
 * 最好: O(n)
 * 平均: O(n^2)
 *
 * @date 2018/02/25
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};

        bubbleSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();


        Character[] arr2 = {'d', 'b', 'a', 'c', 'e'};
        bubbleSort(arr2);

        for (Character i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] array) {
        if (null == array || 1 >= array.length) {
            return;
        }

        boolean ordered = false;
        int temp = 0;

        for (int i = array.length - 1; i > 0 && !ordered; i--) {
            ordered = true;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    ordered = false;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        if (null == array || 1 >= array.length) {
            return;
        }

        boolean ordered = false;
        T temp;

        for (int i = array.length - 1; i > 0 && !ordered; i--) {
            ordered = true;
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    ordered = false;
                }
            }
        }
    }

}
