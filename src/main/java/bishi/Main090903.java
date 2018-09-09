package bishi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/09
 */
public class Main090903 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        String ip = scanner.nextLine().trim();
        List<String> ans = restoreIpAddresses(ip);

        System.out.println(ans.size());
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> answer = new LinkedList<>();

        if (s.length() < 4 || s.length() > 12) {
            return answer;
        }

        dfs(answer, "", s, 0, 0);
        return answer;
    }

    private static void dfs(List<String> answer, String oneAnswer, String s, int partNumber, int start) {
        if (4 == partNumber && start == s.length()) {
            answer.add(oneAnswer);
            return;
        }

        for (int step = 1; step <= 3; step++) {
            if (s.length() - start > (4 - partNumber) * 3) {
                return;
            }
            int end = start + step;
            if (end > s.length()) {
                return;
            }

            String part = s.substring(start, end);
            if (!isValid(part)) {
                return;
            }
            dfs(answer, oneAnswer + part + (3 == partNumber ? "" : "."), s, partNumber + 1, end);
        }
    }

    private static boolean isValid(String str) {
        if ((str.charAt(0) == '0' && str.length() > 1) || Integer.parseInt(str) > 255) {
            return false;
        }
        return true;
    }

}
