/**
 * @author mayuan
 * @desc 顺序查找
 * <p>
 * 时间复杂度
 * 最坏: O(n)
 * 最好: O(1)
 * 平均: O(n)
 * @date 2018/02/26
 */
public class SequenceSearch {

    public static void main(String[] args) {
        int[] arr = {9, 8, 4, 6, 7, 11};

        System.out.println(sequenceSearch(arr, 11));
        System.out.println(sequenceSearch(arr, 10));
    }

    public static int sequenceSearch(int[] array, int value) {
        if (null == array || 0 >= array.length) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return i;
            }
        }

        return -1;
    }
}
