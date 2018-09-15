package bishi.iqiyi;

import java.util.Scanner;

/**
 */
public class Main091502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        if (n < 5) {
            System.out.println(0);
            return;
        }

        int sum = 0;
        int pre = 0;
        int current = 0;
        for (int i = 5; i <= n; ++i) {
            current = pre + countNumberOf5(i);

            sum += current;

            pre = current;
        }

        System.out.println(sum);
    }

    public static int countNumberOf5(int n) {
        int ans = 0;

        if (5 > n || 0 != (n % 5)) {
            return ans;
        } else {
            ++ans;
            return ans + countNumberOf5(n / 5);
        }
    }

}