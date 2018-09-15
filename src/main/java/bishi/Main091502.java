package bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 */
public class Main091502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] temp = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        int p = Integer.parseInt(temp[2]);

        int[][] foods = new int[n][2];
        temp = sc.nextLine().split("\\s+");
        for (int i = 0; i < n; ++i) {
            foods[i][0] = Integer.parseInt(temp[i]);
            foods[i][1] = i;
        }

        for (int i = 0; i < m; ++i) {
            String[] tmp = sc.nextLine().split("\\s+");
            int index = Integer.parseInt(tmp[1]) - 1;

            if ("A".equals(tmp[0])) {
                ++foods[index][0];
            } else {
                --foods[index][0];
            }
        }

        Arrays.sort(foods, (a, b) -> (b[0] - a[0]));

        int[] rate = new int[n];
        rate[0] = 1;
        for (int i = 1; i < n; ++i) {
            if (foods[i - 1][0] == foods[i][0]) {
                rate[i] = rate[i - 1];
            } else {
                rate[i] = i + 1;
            }
        }

        for (int i = 0; i < n; ++i) {
            if (p - 1 == foods[i][1]) {
                System.out.println(rate[i]);
                return;
            }
        }
    }
}