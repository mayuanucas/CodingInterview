import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (0 == i && 0 == j) {
                    dp[i][j] = matrix[i][j];
                }
                if (0 == i && 0 != j) {
                    dp[i][j] = dp[i][j - 1] + matrix[i][j];
                }
                if (0 != i && 0 == j) {
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                }
                if (0 != i && 0 != j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
