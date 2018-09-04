package bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/04
 */
public class Main090402 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int targetTime = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][3];

        for (int i = 0; i < n; ++i) {
            String[] temp = scanner.nextLine().split("\\s+");
            matrix[i][0] = Integer.parseInt(temp[0]);
            matrix[i][1] = Integer.parseInt(temp[1]);
            matrix[i][2] = Integer.parseInt(temp[2]);
        }

        Arrays.sort(matrix, (a, b) -> (a[0] - b[0]));

        boolean flag = false;
        for (int i = 0; i < n; ++i) {
            if (matrix[i][1] <= targetTime && targetTime <= matrix[i][2]) {
                flag = true;
                System.out.println(matrix[i][0]);
            }
        }
        if (!flag) {
            System.out.println("null");
        }
    }
}
