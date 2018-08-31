package algorithm;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/01
 */
public class MySearch {
    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(binarySearch(numbers, 8));
    }

    /**
     * 二分查找:数组需要有序
     * @param array
     * @param searchKey
     * @return
     */
    public static int binarySearch(int[] array, int searchKey) {
        if (null == array || 0 >= array.length) {
            return -1;
        }

        int left = 0, right = array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (searchKey == array[middle]) {
                return middle;
            } else if (searchKey < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
