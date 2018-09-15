package bishi.iqiyi;

import java.util.Scanner;

/**
 */
public class Main091501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] numbers = sc.nextLine().split("\\s+");
        int k = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numbers.length; i += k) {
            reverse(numbers, i, i + k - 1);
        }

        for (int i = 0; i < numbers.length; ++i) {
            System.out.print(numbers[i] + " ");
        }
    }

    private static void reverse(String[] strs, int start, int end) {
        if (end >= strs.length) {
            return;
        }

        while (start < end) {
            String temp = strs[start];
            strs[start] = strs[end];
            strs[end] = temp;

            ++start;
            --end;
        }
    }
}