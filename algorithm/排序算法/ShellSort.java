/**
 * @author mayuan
 * @desc 希尔排序
 * <p>
 * 时间复杂度
 * 最坏: O(n^2)
 * 最好: O(n*log(n))
 * 平均: 取决于增量序列的函数
 * @date 2018/02/25
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {80, 93, 60, 12, 42, 30, 68, 85, 10};

        shellSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void shellSort(int[] array) {
        if (null == array || 1 >= array.length) {
            return;
        }

        int i, j, gap;
        for (gap = array.length / 2; gap > 0; gap /= 2) {
            for (i = gap; i < array.length; i++) {
                for (j = i - gap; j >= 0 && array[j] > array[j + gap]; j -= gap) {
                    int temp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = temp;
                }
            }
        }
    }

}
