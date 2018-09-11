package algorithm;

import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/11
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[n];
        for (int i = 0; i < n; ++i) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < numbers.length; ++i) {
            int minIndex = i + 1;
            for (int j = i + 1; j < numbers.length && minIndex < numbers.length; ++j) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }

            if (numbers[minIndex] < numbers[i]) {
                swap(numbers, minIndex, i);
                break;
            }
        }

        for (int temp : numbers) {
            System.out.print(temp + " ");
        }
    }

    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
