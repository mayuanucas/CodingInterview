package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/06
 */
public class Solution048 {

    /**
     * 1. 沿主对角线反转
     * 2. 水平反转
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        rotateByDui(matrix);
        rotateByH(matrix);
    }

    /**
     * 沿主对角线翻转
     *
     * @param matrix
     */
    private void rotateByDui(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * 水平翻转
     *
     * @param matrix
     */
    private void rotateByH(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

}
