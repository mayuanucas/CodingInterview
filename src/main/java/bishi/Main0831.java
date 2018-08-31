package bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/31
 */
public class Main0831 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = Integer.parseInt(scanner.nextLine());
        String[] temp = scanner.nextLine().split("\\s+");
        int a = Integer.parseInt(temp[0]);
        int x = Integer.parseInt(temp[1]);
        int b = Integer.parseInt(temp[2]);
        int y = Integer.parseInt(temp[3]);
        int[] numbers = new int[x + y];

        if (a > b) {
            Arrays.fill(numbers, a);
            for (int i = 0; i < y; ++i) {
                numbers[i] = b;
            }
        } else {
            Arrays.fill(numbers, b);
            for (int i = 0; i < x; ++i) {
                numbers[i] = a;
            }
        }

        int[] answer = new int[1];
        dfs(numbers, answer, new boolean[numbers.length], k, 0);
        System.out.println(answer[0]);
    }

    private static void dfs(int[] numbers, int[] answer, boolean[] isUsed, int need, int start) {
        if (0 > need) {
            return;
        }
        if (0 == need) {
            ++answer[0];
            if (Integer.MAX_VALUE - 1000 < answer[0]) {
                answer[0] %= 1000000007;
            }
            return;
        }

        for (int i = start; i < numbers.length; ++i) {
            if (numbers[i] > need) {
                return;
            }
            if (!isUsed[i] && numbers[i] <= need) {
                isUsed[i] = true;
                dfs(numbers, answer, isUsed, need - numbers[i], i + 1);
                isUsed[i] = false;
            }
        }
    }

}
