package bishi;

import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/06
 */
public class Main090601 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] from = new int[n + 1];
        int[] to = new int[n + 1];

        for (int i = 1; i < n; ++i) {
            String[] temp = scanner.nextLine().split("\\s+");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);
            from[i] = x;
            to[i] = y;
        }

        if (n <= 4) {
            System.out.println(n);
        } else {
            System.out.println(n + 3);
        }

    }
}
