package bishi;

import java.util.Scanner;

/**
 */
public class Main091602 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());

        while (0 < q--) {
            String[] temp = scanner.nextLine().split("\\s+");
            long k = Long.parseLong(temp[0]);
            long l = Long.parseLong(temp[1]);
            long r = Long.parseLong(temp[2]);

            long ansNum = 0;
            long ansCount = 0;
            for (long i = l; i <= r; ++i) {
                long tmp = numberOfOne(i, k);
                if (tmp > ansCount) {
                    ansNum = i;
                    ansCount = tmp;
                }
            }
            System.out.println(ansNum);
        }
    }

    public static long numberOfOne(long n, long k) {
        long cnt = 0;

        while (0 != n) {
            long tmp = n % k;
            if (tmp == k - 1) {
                ++cnt;
            }

            n /= k;
        }
        return cnt;
    }
}