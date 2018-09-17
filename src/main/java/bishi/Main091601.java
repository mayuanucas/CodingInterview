package bishi;

import java.util.Scanner;

/**
 */
public class Main091601 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];
        int[] sum = new int[n];

        for (int i = 0; i < n; ++i) {
            numbers[i] = scanner.nextInt();
            if (0 != i) {
                sum[i] = sum[i - 1] + numbers[i];
            } else {
                sum[i] = numbers[0];
            }
        }

        boolean hasAnswer = false;
        int max = (numbers[0] > numbers[1]) ? numbers[0] : numbers[1];
        for (int i = 2; i < n; ++i) {
            max = (numbers[i] > max) ? numbers[i] : max;
            if (max < sum[i] - max) {
                hasAnswer = true;
                System.out.println(i + 1);
                break;
            }
        }

        if (!hasAnswer) {
            System.out.println(-1);
        }
    }
}