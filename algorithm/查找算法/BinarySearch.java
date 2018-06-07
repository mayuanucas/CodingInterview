/**
 * @author mayuan
 * @desc
 * @date 2018/02/26
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7, 11};

        System.out.println(binarySearch1(arr, 11, 0, arr.length - 1));
        System.out.println(binarySearch1(arr, 10, 0, arr.length - 1));

        System.out.println(binarySearch2(arr, 7));
        System.out.println(binarySearch2(arr, 13));
    }

    public static int binarySearch1(int[] array, int value, int left, int right) {
        int mid = (left + right) / 2;
        if (array[mid] == value) {
            return mid;
        }

        if (left >= right) {
            return -1;
        }

        if (array[mid] > value) {
            return binarySearch1(array, value, left, mid - 1);
        } else {
            return binarySearch1(array, value, mid + 1, right);
        }
    }

    public static int binarySearch2(int[] array, int value) {
        int left = 0, right = array.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
