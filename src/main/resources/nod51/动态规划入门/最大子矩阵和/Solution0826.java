package nod51.动态规划入门.最大子矩阵和;

import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/26
 */
public class Solution0826 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] temp = scanner.nextLine().split("\\s+");
        int m = Integer.parseInt(temp[0]);
        int n = Integer.parseInt(temp[1]);

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        long answer = 0L;
        for (int i = 0; i < m; ++i) {
            int[] c = new int[n];
            for (int j = i; j < m; ++j) {
                // 计算每列第i行到第j行的和
                for (int k = 0; k < n; ++k) {
                    c[k] = (i == j) ? matrix[i][k] : c[k] + matrix[j][k];
                }
                long current = getMaxSubArray(c);
                if (current > answer) {
                    answer = current;
                }
            }
        }
        System.out.println(answer);
    }

    private static long getMaxSubArray(int[] nums) {
        int start = 0;
        int answerStart = 0, answerEnd = 0;
        long endMax = (long) nums[0];
        long answer = (long) nums[0];

        for (int i = 1; i < nums.length; ++i) {
            if (0 < endMax) {
                endMax += nums[i];
            } else {
                endMax = (long) nums[i];
                start = i;
            }

            if (endMax > answer) {
                answer = endMax;
                answerStart = start;
                answerEnd = i;
            }
        }
//        System.out.println(answerStart + "->" + answerEnd);
        return answer;
    }
}
