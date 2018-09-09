package bishi;

import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/09
 */
public class Main090902 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int m = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[m][m];
        for (int i = 0; i < m; ++i) {
            String[] temp = scanner.nextLine().split("\\s+");
            for (int j = 0; j < m; ++j) {
                if ("1".equals(temp[j])) {
                    matrix[i][j] = '1';
                } else {
                    matrix[i][j] = '0';
                }
            }
        }

        long groupNumber = 0;
        if (null == matrix || 0 >= matrix.length) {
            System.out.println(groupNumber);
            return;
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                if ('0' != matrix[i][j]) {
                    dfs(matrix, i, j);
                    ++groupNumber;
                }
            }
        }
        System.out.println(groupNumber);
    }

    private static void dfs(char[][] matrix, int x, int y) {
        if (0 > x || matrix.length <= x || 0 > y || matrix[x].length <= y || '0' == matrix[x][y]) {
            return;
        }

        matrix[x][y] = '0';
        dfs(matrix, x, y + 1);
        dfs(matrix, x + 1, y);
        dfs(matrix, x, y - 1);
        dfs(matrix, x - 1, y);
    }
}
