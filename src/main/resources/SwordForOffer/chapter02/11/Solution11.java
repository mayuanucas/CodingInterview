/**
 * @author mayuan
 * @desc
 * @date 2018/02/26
 */
public class Solution11 {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int[] numbers = {3, 4, 5, 1, 2};
        System.out.println(minInArray(numbers));

        int[] numbers2 = {1, 0, 1, 1, 1};
        System.out.println(minInArray(numbers2));
    }

    public static int minInArray(int[] array) {
        if (null == array || 0 >= array.length) {
            throw new IllegalArgumentException();
        }

        int left = 0, right = array.length - 1, mid = left;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }

            mid = (left + right) / 2;
            if (array[left] == array[right] && array[left] == array[mid]) {
                return minInOrderArray(array, left, right);
            }

            if (array[mid] >= array[left]) {
                left = mid;
            } else if (array[mid] <= array[right]) {
                right = mid;
            }
        }
        return array[mid];
    }

    public static int minInOrderArray(int[] array, int left, int right) {
        int minNumber = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < minNumber) {
                minNumber = array[i];
            }
        }
        return minNumber;
    }


}
