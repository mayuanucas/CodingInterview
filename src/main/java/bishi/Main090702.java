package bishi;

import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/06
 */
public class Main090702 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int testNumber = Integer.parseInt(scanner.nextLine());

        while (0 < testNumber--) {
            String[] temp = scanner.nextLine().split("\\s+");
            int n = Integer.parseInt(temp[0]);
            int k = Integer.parseInt(temp[1]);
            int leave = n - k;
            if (0 == k || n == k) {
                System.out.println("0 0");
                continue;
            }
            if (2 >= n) {
                System.out.println("0 0");
                continue;
            }

            int min = 0, max = leave;
            if (k <= leave) {
                max = k - 1;
            }


            System.out.println(min + " " + max);
        }
    }
}
