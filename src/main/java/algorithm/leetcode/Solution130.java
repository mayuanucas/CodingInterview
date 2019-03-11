package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 被围绕的区域
 * @date: 2018/08/15
 */
public class Solution130 {
    public static void main(String[] args) {
        Solution130 test = new Solution130();

        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        test.solve(board);

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * 转换思路,从边界开始.标记从边界 'O' 开始,连在一起的区域.
     * 再遍历每个格子,把没有标记的 'O' 替换为要求的记号,并把上一阶段的标记还原.
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (null == board || 0 >= board.length) {
            return;
        }

        // 迭代第一行和最后一行
        for (int j = 0; j < board[0].length; ++j) {
            dfs(board, 0, j);
            dfs(board, board.length - 1, j);
        }
        // 迭代第一列和最后一列
        for (int i = 0; i < board.length; ++i) {
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if ('T' == board[i][j]) {
                    board[i][j] = 'O';
                } else if ('O' == board[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (0 > x || board.length <= x || 0 > y || board[x].length <= y || 'O' != board[x][y]) {
            return;
        }

        board[x][y] = 'T';
        dfs(board, x, y + 1);
        dfs(board, x + 1, y);
        dfs(board, x, y - 1);
        dfs(board, x - 1, y);
    }
}
