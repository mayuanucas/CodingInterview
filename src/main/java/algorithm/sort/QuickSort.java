package algorithm.sort;

/**
 * @author mayuan
 * @desc 快速排序
 * <p>
 * 时间复杂度
 * 最坏: O(n^2)
 * 最好: O(n*log(n)) 或 O(n)
 * 平均: O(n*log(n))
 * @date 2018/02/25
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {36, 9, -7, 45, 23, 61, 15};

        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] array, int left, int right) {
        if (null == array || 0 > left) {
            return;
        }

        int index;
        if (left < right) {
            index = partition(array, left, right);
            quickSort(array, left, index - 1);
            quickSort(array, index + 1, right);
        }
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        while (left < right) {
            while (left < right && array[right] >= pivot) {
                --right;
            }
            array[left] = array[right];

            while (left < right && array[left] <= pivot) {
                ++left;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        return left;
    }
}
