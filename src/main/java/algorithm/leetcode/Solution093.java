package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/13
 */
public class Solution093 {
    public static void main(String[] args) {
        Solution093 test = new Solution093();

        String str = "25525511135";
        String str2 = "0000";
        String str3 = "0279245587303";

        List<String> result = test.restoreIpAddresses(str3);

        result.forEach(System.out::println);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> answer = new LinkedList<>();

        if (s.length() < 4 || s.length() > 12) {
            return answer;
        }

        dfs(answer, "", s, 0, 0);
        return answer;
    }

    private void dfs(List<String> answer, String oneAnswer, String s, int partNumber, int start) {
        // ip 由四段构成,并且由全部字符串组成(两个判断条件缺一不可)
        if (4 == partNumber && start == s.length()) {
            answer.add(oneAnswer);
            return;
        }

        for (int step = 1; step <= 3; step++) {
            // 余下的字符串长度 远大于 合法ip字符串最大长度 (大大减小运行时间)
            if (s.length() - start > (4 - partNumber) * 3) {
                return;
            }
            int end = start + step;
            // 索引位置超出字符串长度,直接返回
            if (end > s.length()) {
                return;
            }

            String part = s.substring(start, end);
            if (!isValid(part)) {
                return;
            }
            // 此处传递的是新的字符串,故无需再从字符串中删除当前轮迭代添加的字符串
            dfs(answer, oneAnswer + part + (3 == partNumber ? "" : "."), s, partNumber + 1, end);
        }
    }

    private boolean isValid(String str) {
        if ((str.charAt(0) == '0' && str.length() > 1) || Integer.parseInt(str) > 255) {
            return false;
        }
        return true;
    }
}
