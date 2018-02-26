/**
 * @author mayuan
 * @desc 直接插入排序
 *
 * 时间复杂度
 * 最坏: O(n^2)
 * 最好: O(n)
 * 平均: O(n^2)
 *
 * @date 2018/02/26
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 4, 6, 7, 11};

        insertSort(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}
