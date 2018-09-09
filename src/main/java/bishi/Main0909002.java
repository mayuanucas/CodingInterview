package bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 */
public class Main0909002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][3];
        for (int i = 0; i < n; ++i) {
            matrix[i][0] = scanner.nextInt();
            matrix[i][1] = scanner.nextInt();
            matrix[i][2] = scanner.nextInt();
        }

        Arrays.sort(matrix, (a, b) -> (a[0] - b[0]));

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((matrix[i][0] < matrix[j][0]) &&
                        (matrix[i][1] < matrix[j][1]) &&
                        (matrix[i][2] < matrix[j][2])) {
                    ++ans;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}