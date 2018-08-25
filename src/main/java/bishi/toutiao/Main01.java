package bishi.toutiao;

import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/25
 */
public class Main01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n个人
        int n = Integer.valueOf(scanner.nextLine());
        // 读取数据,构建数组
        int[][] M = new int[n][n];
        for (int i = 0; i < n; ++i) {
            String[] temp = scanner.nextLine().split("\\s+");
            for (int index = 0; index < temp.length - 1; ++index) {
                int j = Integer.valueOf(temp[index]) - 1;
                M[i][j] = 1;
                M[j][i] = 1;
            }
        }

        int ans = findMinGroups(M);
        System.out.println(ans);
    }

    private static int findMinGroups(int[][] M) {
        if (null == M || 0 >= M.length) {
            return 0;
        }

        int minGroups = 0;
        boolean[] hasVisited = new boolean[M.length];
        for (int i = 0; i < M.length; ++i) {
            if (!hasVisited[i]) {
                dfs(M, hasVisited, i);
                ++minGroups;
            }
        }
        return minGroups;
    }

    private static void dfs(int[][] M, boolean[] hasVisited, int i) {
        hasVisited[i] = true;
        for (int j = 0; j < M.length; ++j) {
            if (1 == M[i][j] && !hasVisited[j]) {
                dfs(M, hasVisited, j);
            }
        }
    }

}
