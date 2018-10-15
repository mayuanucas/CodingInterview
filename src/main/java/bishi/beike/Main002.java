package bishi.beike;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/10/15
 */
public class Main002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();

        String[] numbers = input.split("[+-]");
        char[] flags = new char[numbers.length - 1];

        int i = 0;
        for (char c : input.toCharArray()) {
            if ('-' == c || '+' == c) {
                flags[i++] = c;
            }
        }

        List<Integer> list = new LinkedList<>();
        for (String str : numbers) {
            if (str.length() >= 2 &&
                    ('0' == str.charAt(0)) && ('x' == str.charAt(1) || 'X' == str.charAt(1))) {
                list.add(Integer.parseInt(str.substring(2), 16));
            } else if (str.length() >= 2 &&
                    ('0' == str.charAt(0))) {
                list.add(Integer.parseInt(str, 8));
            } else {
                list.add(Integer.parseInt(str, 10));
            }

        }

        int ans = list.get(0);
        for (int n = 1; n < list.size(); ++n) {
            char c = flags[n - 1];
            if ('+' == c) {
                ans += list.get(n);
            } else {
                ans -= list.get(n);
            }
        }
        System.out.println(ans);
    }

}
