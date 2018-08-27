package SwordForOffer.chapter03;

/**
 * @author mayuan
 * @desc
 * @date 2018/03/01
 */
public class Solution21 {

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        reOrderOddEven(data);
        for (int number : data) {
            System.out.print(number + " ");
        }
    }

    public static void reOrderOddEven(int[] data) {
        reOrder(data);
    }

    public static void reOrder(int[] data) {
        if (null == data || 1 >= data.length) {
            return;
        }

        int left = 0, right = data.length - 1;
        while (left < right) {
            while (left < right && !isEven(data[left])) {
                left++;
            }
            while (left < right && isEven(data[right])) {
                right--;
            }
            if (left < right) {
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            }
        }
    }

    public static boolean isEven(int number) {
        return (number & 1) == 0;
    }
}
