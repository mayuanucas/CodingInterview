package bishi.iqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 */
public class Main091503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(matrix[i], 1);
        }

        for (int i = 0; i < m; ++i) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            matrix[x][y] = 0;
            matrix[y][x] = 0;
        }

        // 根据条件,某些节点不能放在同一个集合中,需要的划分数目
        int count = 0;
        boolean[] ans = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!ans[i]) {
                if (2 > count) {
                    dfs(matrix, ans, i);
                    ++count;
                } else {
                    // 本题划分大于2时直接退出即可
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(1);
    }

    public static void dfs(int[][] matrix, boolean[] hasVisited, int i) {
        // 标记该节点为已访问过
        hasVisited[i] = true;
        for (int j = 0; j < matrix[i].length; ++j) {
            if ((1 == matrix[i][j]) && !hasVisited[j]) {
                dfs(matrix, hasVisited, j);
            }
        }
    }
}