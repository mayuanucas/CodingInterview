package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/16
 */
public class Solution037 {
    public static void main(String[] args) {

    }

    public void solveSudoku(char[][] board) {
        if (null == board || 0 >= board.length) {
            return;
        }

        dfs(board);
    }

    private boolean dfs(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if ('.' == board[i][j]) {
                    // 从1到9遍历尝试
                    for (char c = '1'; c <= '9'; c++) {
                        // 当前位置放 c 字符合适
                        if (isValid(board, i, j, c)) {
                            // 更新该位置为当前的字符
                            board[i][j] = c;
                            // 进行迭代
                            if (dfs(board)) {
                                return true;
                            } else {
                                // 恢复该位置为原始的字符
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; ++i) {
            // 检查行
            if ('.' != board[i][col] && c == board[i][col]) {
                return false;
            }
            // 检查列
            if ('.' != board[row][i] && c == board[row][i]) {
                return false;
            }
            // 检查小宫格子
            if ('.' != board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] &&
                    c == board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3]) {
                return false;
            }
        }
        return true;
    }
}
