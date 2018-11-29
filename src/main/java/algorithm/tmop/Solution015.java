package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 矩阵乘法
 * 时间复杂度: O(n^3)
 * 空间复杂度:
 * @date:
 */
public class Solution015 {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {1, 1, 1}};
        int[][] b = {{1, 1}, {1, 1}, {1, 1}};

        printMatrix(a);
        printMatrix(b);
        matrixMul(a, b);
    }

    public static void matrixMul(int[][] a, int[][] b) {
        if (null == a || null == b || 0 >= a.length || 0 >= b.length || a[0].length != b.length) {
            throw new IllegalArgumentException();
        }

        int row = a.length;
        int col = b[0].length;
        int[][] c = new int[row][col];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                for (int k = 0; k < a[0].length; ++k) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        printMatrix(c);
    }

    public static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < a[0].length; ++j) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
