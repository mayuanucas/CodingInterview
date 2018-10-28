package algorithm.alg4;

/**
 * @author: mayuan
 * @desc: 二分查找的递归实现
 * @date: 2018/10/28
 */
public class Solution002 {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 6;

        System.out.print("key==" + key + "的下标为: ");
        System.out.println(binarySearch(array, key));
    }

    public static int binarySearch(int[] array, int key) {
        return binarySearch(array, key, 0, array.length);
    }

    public static int binarySearch(int[] array, int key, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if (key < array[mid]) {
            return binarySearch(array, key, left, mid - 1);
        } else if (key > array[mid]) {
            return binarySearch(array, key, mid + 1, right);
        } else {
            return mid;
        }
    }
}
