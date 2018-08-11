package bishi;

import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/05
 */
public class Main001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            int h = 1 + input.length() / 4;

            char[][] matrix = getMatrix(h);
            int index = 0;

            // 得到第 0 行
            for (int j = 0; j < h; j++) {
                matrix[0][j] = input.charAt(j);
            }
            // 得到最右侧的列
            index = h;
            for (int i = 1; i < h - 1; i++, index++) {
                matrix[i][h - 1] = input.charAt(index);
            }
            // 得到第 h-1 行
            for (int j = h - 1; j >= 0; j--, index++) {
                matrix[h - 1][j] = input.charAt(index);
            }
            // 得到最左侧的列
            for (int i = h - 2; i > 0; i--, index++) {
                matrix[i][0] = input.charAt(index);
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
    }

    private static char[][] getMatrix(int n) {
        char[][] matrix = new char[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = new char[n];
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ' ';
            }
        }
        return matrix;
    }
}
