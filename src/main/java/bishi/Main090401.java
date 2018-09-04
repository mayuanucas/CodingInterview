package bishi;

import java.util.Scanner;

/**
 * @author: mayuan
 * @desc: 求二进制中1的个数
 * @date: 2018/09/04
 */
public class Main090401 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        long ans = 0;

        while (0 != number) {
            ++ans;
            number = number & (number - 1);
        }
        System.out.println(ans);

    }
}
