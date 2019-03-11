package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 岛屿的最大面积
 * @date: 2018/08/15
 */
public class Solution695 {
    public static void main(String[] args) {
        Solution695 test = new Solution695();

        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        System.out.println(test.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (null == grid || grid.length <= 0) {
            return 0;
        }

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (0 > x || grid.length <= x || 0 > y || grid[x].length <= y || 0 == grid[x][y]) {
            return 0;
        }

        // 标记当前节点为0,表示已经搜索过该区域
        grid[x][y] = 0;

        return 1 + dfs(grid, x, y + 1) + dfs(grid, x + 1, y) + dfs(grid, x, y - 1) + dfs(grid, x - 1, y);
    }
}
