package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 行列递增矩阵的查找
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @date:
 */
public class Solution019 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};

        final int target = 6;
        System.out.println(matrixSearch(matrix, target));
    }

    public static boolean matrixSearch(int[][] matrix, int target) {
        if (null == matrix || 0 >= matrix.length) {
            return false;
        }

        int i = 0;
        int j = matrix[0].length - 1;
        while (true) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j] && i < matrix.length - 1) {
                ++i;
            } else if (target < matrix[i][j] && j > 0) {
                --j;
            } else {
                return false;
            }
        }
    }

}
