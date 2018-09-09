package bishi;

import java.util.Scanner;

/**
 */
public class Main0909001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNumber = Integer.parseInt(sc.nextLine());

        while (0 < testNumber--) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] matrix = new int[m][2];
            for (int i = 0; i < m; ++i) {
                matrix[i][0] = sc.nextInt();
                matrix[i][1] = sc.nextInt();
            }

            if (0 == (n + m) % 2) {
                System.out.println("NO");
            }
            System.out.println("YES");
        }
    }
}