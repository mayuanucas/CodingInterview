/**
 * @author mayuan
 * @desc
 * @date 2018/03/03
 */
public class Solution29 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatrixClockwisely(matrix, 4, 4);
    }

    public static void printMatrixClockwisely(int[][] numbers, int rows, int columns) {
        if (null == numbers || columns <= 0 || 0 >= rows) {
            return;
        }
        int start = 0;
        while (columns > start * 2 && rows > start * 2) {
            printMatrixInCircle(numbers, columns, rows, start);
            ++start;
        }
    }

    public static void printMatrixInCircle(int[][] numbers, int columns, int rows, int start) {
        int endRow = rows - 1 - start;
        int endColumn = columns - 1 - start;

        for (int i = start; i <= endColumn; ++i) {
            System.out.println(numbers[start][i]);
        }

        if (start < endRow) {
            for (int i = start + 1; i <= endRow; ++i) {
                System.out.println(numbers[i][endColumn]);
            }
        }

        if (start < endColumn && start < endRow) {
            for (int i = endColumn - 1; i >= start; --i) {
                System.out.println(numbers[endRow][i]);
            }
        }

        if (start < endColumn && start < endRow - 1) {
            for (int i = endRow - 1; i >= start + 1; --i) {
                System.out.println(numbers[i][start]);
            }
        }
    }
}
