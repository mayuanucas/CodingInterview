package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 有序数组的查找
 * 时间复杂度: O(logN)
 * 空间复杂度: O(1)
 * @date:
 */
public class Solution018 {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int target = 8;
        System.out.println("target=" + target + "的下标为:" + binarySearch(array, target));
    }

    /**
     * 对于有序数组,首选二分查找.
     * 找到元素则返回该元素的下标,未找到则返回-1
     *
     * @param array
     * @param target
     * @return
     */
    public static int binarySearch(int[] array, int target) {
        if (null == array || 0 >= array.length) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] > target) {
                right = middle - 1;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

}
