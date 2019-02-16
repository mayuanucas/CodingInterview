package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 字母大小写全排列
 * @date: 2019/02/16
 */
public class Solution784 {

    public List<String> letterCasePermutation(String S) {
        List<String> ans = new LinkedList<>();

        if (null == S) {
            return ans;
        }

        dfs(ans, S.toCharArray(), 0);
        return ans;
    }

    public void dfs(List<String> answer, char[] chs, int start) {
        if (start == chs.length) {
            answer.add(new String(chs));
            return;
        }

        if ('0' <= chs[start] && chs[start] <= '9') {
            dfs(answer, chs, start + 1);
        } else {
            chs[start] = Character.toLowerCase(chs[start]);
            dfs(answer, chs, start + 1);

            chs[start] = Character.toUpperCase(chs[start]);
            dfs(answer, chs, start + 1);
        }
    }
}
