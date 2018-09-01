package bishi;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 拼多多
 * <p>
 * 求循环小数位置和循环体长度
 */
public class Main0901 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        int k = m % n;
        int count = 0;
        while (map.get(k) == null && k != 0) {
            map.put(k, count++);
            k *= 10;
            k %= n;
        }
        if (k == 0) {
            System.out.println(count + " " + 0);
        } else {
            System.out.println(map.get(k) + " " + (count - map.get(k)));
        }
    }
}