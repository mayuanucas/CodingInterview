package bishi;

import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/06
 */
public class Main090701 {

    /**
     * 先考虑n = m = 1的情况，翻转一次，故输出1
     * 我们令输入的n <= m
     * 当n = 1,m > 1时，最边上两块会被翻转两次，中间的会被翻转三次，故输出（m - 2）
     * 当2 <= n <= m时，四个角会被翻转四次，四边上除了角外的部分会被翻转六次，
     * 中间剩余的部分会被翻转九次，故输出(n - 2)(m - 2)
     *
     * @param args
     */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int testNumber = Integer.parseInt(scanner.nextLine());

        while (0 < testNumber--) {
            String[] temp = scanner.nextLine().split("\\s+");
            long n = Long.parseLong(temp[0]);
            long m = Long.parseLong(temp[1]);

            if (n > m) {
                long tmp = n;
                n = m;
                m = tmp;
            }

            if (0 == n || 0 == m) {
                System.out.println(0);
                continue;
            } else if (1 == n && 1 == m) {
                System.out.println(1);
                continue;
            } else if (1 == n) {
                System.out.println(m - 2);
                continue;
            } else {
                System.out.println((n - 2) * (m - 2));
            }
        }
    }
}
