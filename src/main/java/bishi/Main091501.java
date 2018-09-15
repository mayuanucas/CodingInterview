package bishi;

import java.util.Scanner;

/**
 */
public class Main091501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine().trim();
        int[] numbers = new int[input.length()];
        int i = 0;
        for (char c : input.toCharArray()) {
            numbers[i++] = c - '0';
        }

        if (isEqual(numbers)) {
            System.out.println(0);
            return;
        }

        int left = numbers[0] + numbers[1] + numbers[2];
        int right = numbers[3] + numbers[4] + numbers[5];
        if (left < right) {
            int cha = right - left;
            int count = 0;
            for (int j = 0; j < 3; ++j) {
                int tmp = 9 - numbers[j];
                cha -= tmp;
                ++count;
                if (0 >= cha) {
                    break;
                }
            }
            System.out.println(count);
        } else {
            int cha = left - right;
            int count = 0;
            for (int j = 3; j < 6; ++j) {
                int tmp = 9 - numbers[j];
                cha -= tmp;
                ++count;
                if (0 >= cha) {
                    break;
                }
            }
            System.out.println(count);
        }
    }

    public static boolean isEqual(int[] numbers) {
        int temp = 0;
        for (int i = 0; i < 3; ++i) {
            temp += numbers[i];
        }
        for (int i = 3; i < 6; ++i) {
            temp -= numbers[i];
        }

        return (0 == temp) ? true : false;
    }
}