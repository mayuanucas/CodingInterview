/**
 * @author mayuan
 * @desc
 * @date 2018/02/26
 */
public class Solution12 {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        char[][] matrix = {
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}};

        char[] str = {'b', 'f', 'c', 'e'};

        System.out.println(hasPath(matrix, str));

    }

    public static boolean hasPath(char[][] matrix, char[] str) {
        if (null == matrix || null == str || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int pathLength = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPathCore(char[][] matrix, int row, int col, char[] str, int pathLength, boolean[][] visited) {
        if (pathLength == str.length) {
            return true;
        }

        boolean hasPath = false;
        if (row >= 0 && row < matrix.length &&
                col >= 0 && col < matrix[0].length &&
                matrix[row][col] == str[pathLength] &&
                !visited[row][col]) {
            ++pathLength;
            visited[row][col] = true;

            hasPath = hasPathCore(matrix, row, col - 1, str, pathLength, visited) ||
                    hasPathCore(matrix, row - 1, col, str, pathLength, visited) ||
                    hasPathCore(matrix, row, col + 1, str, pathLength, visited) ||
                    hasPathCore(matrix, row + 1, col, str, pathLength, visited);

            if (!hasPath) {
                --pathLength;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }

}
