package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 岛屿的个数
 * @date: 2018/08/15
 */
public class Solution200 {
    public static void main(String[] args) {
        Solution200 test = new Solution200();

        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        System.out.println(test.numIslands(grid));
    }

    /**
     * 上帝之手: 点击一个格子(陆地)即可让相连在一块的陆地全部变为海洋,则需要点几次可以把全部区域变为海洋?
     * 结果即代表:有几块陆地.
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (null == grid || 0 >= grid.length) {
            return 0;
        }

        int island = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if ('0' != grid[i][j]) {
                    dfs(grid, i, j);
                    ++island;
                }
            }
        }
        return island;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (0 > x || grid.length <= x || 0 > y || grid[x].length <= y || '0' == grid[x][y]) {
            return;
        }

        grid[x][y] = '0';
        dfs(grid, x, y + 1);
        dfs(grid, x + 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x - 1, y);
    }
}
