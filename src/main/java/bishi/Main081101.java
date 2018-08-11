package bishi;

import java.util.Scanner;

/**
 * @author: mayuan
 * @desc: 网易-苹果堆
 * @date: 2018/08/11
 */
public class Main081101 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 苹果堆的数目
        int n = scanner.nextInt();
        // 累加和
        int[] apple = new int[n];
        for (int i = 0; i < n; i++) {
            if (0 == i) {
                apple[i] = scanner.nextInt();
            }
            if (0 < i) {
                apple[i] = apple[i - 1] + scanner.nextInt();
            }
        }
        int m = scanner.nextInt();
        int[] q = new int[m];
        for (int i = 0; i < m; i++) {
            q[i] = scanner.nextInt();
        }

        for (int questionID = 0; questionID < m; questionID++) {
            System.out.println(binarySearch1(apple, q[questionID], 0, n - 1));
        }
    }

    public static int binarySearch1(int[] array, int value, int left, int right) {
        int mid = (left + right) / 2;
        if (value <= array[left]) {
            return left + 1;
        }
        if (1 <= right && array[right - 1] < value && value <= array[right]) {
            return right + 1;
        }
        if (array[mid - 1] < value && value <= array[mid]) {
            return mid + 1;
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

}
