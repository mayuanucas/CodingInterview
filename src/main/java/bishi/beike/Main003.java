package bishi.beike;

import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/10/15
 */
public class Main003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine());

        while (0 < (t--)) {
            String[] temp = scanner.nextLine().split("\\s+");
            int X = Integer.parseInt(temp[0]);
            int A = Integer.parseInt(temp[1]);
            int C = Integer.parseInt(temp[2]);
            int Y = Integer.parseInt(temp[3]);
            int B = Integer.parseInt(temp[4]);
            int D = Integer.parseInt(temp[5]);

            long t1 = 0, t2 = 0;
            while ((0 < X) && (0 < Y)) {
                if (0 == t1 % C) {
                    Y -= A;
                    t1 = 0;
                }
                if (0 == t2 % D) {
                    X -= B;
                    t2 = 0;
                }

                long tt1 = C - t1;
                long tt2 = D - t2;
                long min = tt1 < tt2 ? tt1 : tt2;

                t1 += min;
                t2 += min;
            }

            if ((0 >= X) && (0 > Y)) {
                System.out.println("XIAOCHUN");
            } else if (0 < X && 0 >= Y) {
                System.out.println("XIAOZHI");
            } else {
                System.out.println("TIE");
            }
        }

    }

}
