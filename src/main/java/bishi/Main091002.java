package bishi;

import java.util.Scanner;

/**
 */
public class Main091002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        long[] numbers = new long[2000];
        numbers[0] = 1L;

        int i = 1;
        for (long num = 2; i < numbers.length; ++num) {
            if (isUglyNumber(num)) {
                numbers[i++] = num;
            }
        }

//        int num = 2;
//        for (int i = 1; i < numbers.length; ++i) {
//            while (true) {
//                if (isUglyNumber(num)) {
//                    numbers[i] = num;
//                    ++num;
//                    break;
//                } else {
//                    ++num;
//                }
//            }
//        }

        System.out.println(numbers[n - 1]);
    }

    public static boolean isUglyNumber(long number) {
        if (2 == number || 3 == number || 5 == number) {
            return true;
        }

        if (0 == number % 2 || 0 == number % 3 || 0 == number % 5) {
            return isUglyNumber(number / 2) || isUglyNumber(number / 3) || isUglyNumber(number / 5);
        }
        return false;
    }
}