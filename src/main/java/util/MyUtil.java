package util;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/06
 */
public class MyUtil {
    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
