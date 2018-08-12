package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/12
 */
public class Solution079 {

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String str1 = "ABCCED";
        String str2 = "SEE";
        String str3 = "ABCB";

        Solution079 test = new Solution079();
        System.out.println(test.exist(board, str1));
        System.out.println(test.exist(board, str2));
        System.out.println(test.exist(board, str3));
    }

    public boolean exist(char[][] board, String word) {
        if (0 >= board.length || 0 >= word.length()) {
            return false;
        }

        // 尝试从每个位置开始探测,如果可以搜索到该单词,则返回 true
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int index) {
        if (index == word.length()) {
            return true;
        }

        if (0 > x || 0 > y || board.length <= x || board[x].length <= y) {
            return false;
        }
        if (board[x][y] != word.charAt(index)) {
            return false;
        }

        // 标记该位置,代表已经走过该位置
        char temp = board[x][y];
        board[x][y] = '*';

        boolean answer = dfs(board, word, x + 1, y, index + 1) ||
                dfs(board, word, x, y + 1, index + 1) ||
                dfs(board, word, x - 1, y, index + 1) ||
                dfs(board, word, x, y - 1, index + 1);

        // 经过该位置搜索不到该单词,将该位置的单词还原
        board[x][y] = temp;
        return answer;
    }
}
