package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 太平洋大西洋水流问题
 * 1、分别处理每个海洋，从海洋边缘（每个海洋两条边）开始，一步步的搜索，即从连接海洋的地方还是搜索，
 * 哪些节点的高度高于等于自身（反过来就是可以从那里流到自己），如果是，就标记为true，就这样不断搜索下去。
 * 最后所有标记为true的位置就是可以流到对应的海洋。
 * <p>
 * 2、找这两个矩阵，同为true的输出，就是都能流到两个海洋的位置
 * @date: 2018/08/15
 */
public class Solution417 {
    public static void main(String[] args) {
        Solution417 test = new Solution417();

        int[][] matrix = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        List<int[]> ans = test.pacificAtlantic(matrix);
        ans.forEach(array -> {
            System.out.print(array[0]);
            System.out.print(",");
            System.out.print(array[1]);
            System.out.println();
        });
    }

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> answer = new LinkedList<>();

        if (null == matrix || 0 >= matrix.length) {
            return answer;
        }

        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int line = matrix.length;
        int column = matrix[0].length;
        boolean[][] canReachP = new boolean[line][column];
        boolean[][] canReachA = new boolean[line][column];

        for (int i = 0; i < line; ++i) {
            dfs(matrix, direction, canReachP, i, 0);
            dfs(matrix, direction, canReachA, i, column - 1);
        }

        for (int j = 0; j < column; ++j) {
            dfs(matrix, direction, canReachP, 0, j);
            dfs(matrix, direction, canReachA, line - 1, j);
        }

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    answer.add(new int[]{i, j});
                }
            }
        }

        return answer;
    }

    private void dfs(int[][] matrix, int[][] direction, boolean[][] canReach, int x, int y) {
        if (canReach[x][y]) {
            return;
        }

        canReach[x][y] = true;
        for (int[] d : direction) {
            int nextX = d[0] + x;
            int nextY = d[1] + y;
            // 反向推导, 只有当下一个位置的高度大于等于当前高度, 水才能从其位置流过来.
            if (0 > nextX || matrix.length <= nextX
                    || 0 > nextY || matrix[nextX].length <= nextY
                    || matrix[x][y] > matrix[nextX][nextY]) {
                continue;
            }
            dfs(matrix, direction, canReach, nextX, nextY);
        }
    }
}
