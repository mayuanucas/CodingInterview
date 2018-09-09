package bishi;

import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/09
 */
public class Main090905 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < m; ++i) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            matrix[x][y] = 1;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (1 == matrix[i][j]) {
                    addRow(matrix, i, j);
                }
            }
        }

        int ans = 0;
        for (int j = 0; j < n; ++j) {
            int count = 0;
            for (int i = 0; i < n; ++i) {
                if (i == j) {
                    continue;
                }
                if (1 == matrix[i][j]) {
                    ++count;
                }
            }
            if (n - 1 == count) {
                ++ans;
            }
        }
        System.out.println(ans);
    }

    private static void addRow(int[][] matrix, int x, int y) {
        for (int i = 0; i < matrix[0].length; ++i) {
            matrix[x][i] += matrix[y][i];
        }
    }
}
