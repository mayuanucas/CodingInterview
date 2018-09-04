package algorithm;

/**
 * @author: mayuan
 * @desc: 合并两个有序数组
 * @date: 2018/09/04
 */
public class MergeArray {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9};
        int[] b = {0, 2, 4, 6, 8};

        int[] array = mergeArray(a, b);
        printArray(array);
    }

    public static int[] mergeArray(int[] a, int[] b) {
        int length = a.length + b.length;
        int[] array = new int[length];

        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                array[k++] = a[i++];
            } else {
                array[k++] = b[j++];
            }
        }

        while (i < a.length) {
            array[k++] = a[i++];
        }
        while (j < b.length) {
            array[k++] = b[j++];
        }

        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
