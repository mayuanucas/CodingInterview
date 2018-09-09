package bishi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/09
 */
public class Main090901 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        int count = 0;
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                ++count;
                if (maxLength < count) {
                    maxLength = count;
                }
            } else {
                count = 1;
                if (maxLength < count) {
                    maxLength = count;
                }
                set.clear();
                set.add(c);
            }
        }

        System.out.println(maxLength);
    }
}
